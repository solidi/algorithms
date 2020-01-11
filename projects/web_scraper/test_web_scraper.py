import web_scraper
import unittest
import requests
from mock import MagicMock


class TestWebScrapper(unittest.TestCase):
    def setUp(self):
        self.agent = MagicMock()
        self.request = MagicMock()
        self.request.status_code = 200
        self.request.text.encode = MagicMock(
            return_value=open('./test_html.html', 'r').read())
        self.agent.get = MagicMock(return_value=self.request)

        self.number_of_tags, self.top_five = web_scraper.main(
            self.agent, verbose=False)

        self.top_five_tags = [x[0] for x in self.top_five]
        self.top_five_counts = [x[1] for x in self.top_five]

    def test_number_of_tags(self):
        self.assertEqual(self.number_of_tags, 8)

    def test_top_tags(self):
        self.assertEqual(self.top_five_tags, ['body', 'head', 'html', 'title'])

    def test_top_five_counts(self):
        self.assertEqual(self.top_five_counts, [2, 2, 2, 2])


class TestCollateAndCountTags(unittest.TestCase):
    def test_ignores_comment_tag(self):
        types_, lengths = web_scraper.collate_and_count_tags(
            "<!-- Hello -->")
        types_ = [x for x in types_]

        self.assertEquals(types_, [])

    def test_includes_comment_count(self):
        types_, lengths = web_scraper.collate_and_count_tags(
            "<title><!-- Hello --></title>")
        print(types_)
        types_ = [x for x in types_]

        self.assertEquals(types_, ['title'])
        self.assertEquals(lengths, 3)

    def test_functional_html(self):
        types_, lengths = web_scraper.collate_and_count_tags(
            open('./test_html.html', 'r').read())
        types_ = [x for x in types_]

        self.assertEquals(types_, ['body', 'head', 'html', 'title'])
        self.assertEquals(lengths, 8)


class TestPrintOutput(unittest.TestCase):
    def test_returns_output(self):
        result = web_scraper.print_output({'title': 2}, 2, verbose=True)
        self.assertEquals(result, (2, [('title', 2)]))


class TestLoadHtml(unittest.TestCase):
    def setUp(self):
        self.agent = MagicMock()
        self.request = MagicMock()
        self.request.text.encode = MagicMock(return_value='<html></html>')
        self.agent.get = MagicMock(return_value=self.request)

    def test_loads_html_on_200(self):
        self.request.status_code = 200

        result = web_scraper.load_html(
            'example.com', self.agent, filename='example.html', verbose=True)

        self.assertEquals(result, '<html></html>')


if __name__ == '__main__':
    loader = unittest.TestLoader()
    suite = unittest.TestSuite()
    suite.addTests(loader.loadTestsFromTestCase(TestWebScrapper))
    suite.addTests(loader.loadTestsFromTestCase(TestCollateAndCountTags))
    suite.addTests(loader.loadTestsFromTestCase(TestPrintOutput))
    suite.addTests(loader.loadTestsFromTestCase(TestLoadHtml))
    unittest.TextTestRunner(verbosity=2, buffer=True).run(suite)
