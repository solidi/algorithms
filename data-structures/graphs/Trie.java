import java.io.*;
import java.util.*;

/*
  Trie (Retrieval, or Prefix Tree)
  Used for quick string look up O(k) and identifies strings that begin with.
  https://www.geeksforgeeks.org/trie-insert-and-search/
*/
class Solution {
    public static class Trie {
        private class TrieNode {
            private int ALPHABET_SIZE = 26;
            private TrieNode children[] = new TrieNode[ALPHABET_SIZE];
            private boolean isEndOfWord = false;

            public TrieNode() {
                for (int i = 0; i < ALPHABET_SIZE; i++) {
                    children[i] = null;
                }
            }
        }

        private TrieNode root = new TrieNode();

        public void insert(String key) {
            int level, index, length = key.length();
            TrieNode current = root;

            for (level = 0; level < length; level++) {
                index = key.charAt(level) - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }

            current.isEndOfWord = true;
        }

        public boolean search(String key) {
            int level, index, length = key.length();
            TrieNode current = root;

            for (level = 0; level < length; level++) {
                index = key.charAt(level) - 'a';
                if (current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }

            return (current != null && current.isEndOfWord);
        }
    }

    public static void main(String args[]) {
        String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };
        Trie trie = new Trie();
        for (int i = 0; i < keys.length; i++) {
            trie.insert(keys[i]);
        }
        System.out.println(trie.search("the"));
        System.out.println(trie.search("these"));
        System.out.println(trie.search("their"));
        System.out.println(trie.search("thaw"));
    }
}
