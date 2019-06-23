# This exercise is to build a web page scraper in python and generate some basic metrics about the page.

# Requirements:
# A "README" explaining usage and any dependencies/setup/caveats/etc
# The exercise should be written in Python 2.7 - if not possible, please include this requirement in the README
# No external python libraries are allowed
# In whatever output format you see fit, your code should hit the target domain and output the total # of HTML elements and the top 5 most frequently used tags, and their respective counts.
# BONUS: Write tests to make sure your code is behaving correctly.


import requests
import re
import os
import sys
from collections import defaultdict


def print_output(tags, number_of_tags, verbose=True):
    top_five_items = sorted(tags.items(), key=lambda x: -x[1])[:5]
    template = '{0:8}{1:>8}'
    if verbose:
        print 'Total number of tags (includes open, close, and comment):', number_of_tags
        print 'Top 5 tag types:'
        print template.format('TAG TYPE', 'COUNT')
        for tag, count in top_five_items:
            print template.format(tag, count)

    return number_of_tags, top_five_items


def collate_and_count_tags(html):
    all_tags = re.findall('<.*?>', html)  # find tags in greedy fashion
    tags = filter(lambda x: x[1] != '!', all_tags)  # ignore comment tags

    # create the tag dictionary
    tag_container = defaultdict(int)
    for tag in tags:
        tag_type = re.sub('[<>/]', '', tag.split()[0])
        tag_container[tag_type] += 1

    return tag_container, len(all_tags)


def load_html(url, agent, **kwargs):
    if 'filename' in kwargs:
        if kwargs['verbose']:
            print 'retrieving data from: {}'.format(url)
        try:
            req = agent.get(url)
            html = req.text.encode('utf-8')
        except Exception as e:
            if kwargs['verbose']:
                print '{}. Exiting.'.format(e.message)
            sys.exit()
        if req.status_code != 200:
            if kwargs['verbose']:
                print 'Status code {}. Exiting.'.format(req.status_code)
            sys.exit()

    return html


def main(agent, verbose=True):
    html = load_html('http://google.com', agent,
                     filename='google.html', verbose=verbose)
    tags, number_of_tags = collate_and_count_tags(html)
    return print_output(tags, number_of_tags, verbose=verbose)


if __name__ == '__main__':
    main(requests)
