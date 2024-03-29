package com.trie;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstruction {

    public static void main(String[] args) {
        String str = "invisible";
        SuffixTrie suffixTrie = new SuffixTrie();
        suffixTrie.populateSuffixTrie(str);
        System.out.println(suffixTrie.search("ble"));
    }

    public static class TrieNode {
        Map<Character, TrieNode> childNodeMap = new HashMap<Character, TrieNode>();
    }

    public static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public void populateSuffixTrie(String str) {
            for (int i = 0; i < str.length(); i++) {
                 insertSubstringStartingAt(i, str);
            }
        }

        public void insertSubstringStartingAt(int i, String str) {
            TrieNode current = root;

            for (int j = i; j < str.length(); j++) {
                 char letter = str.charAt(j);
                 if (!current.childNodeMap.containsKey(letter)) {
                     TrieNode newNode = new TrieNode();
                     current.childNodeMap.put(letter, newNode);
                 }
                 current = current.childNodeMap.get(letter);
            }

            current.childNodeMap.put(endSymbol, null);
        }

        public boolean search(String str) {
            TrieNode current = root;

            for (int j = 0; j < str.length(); j++) {
                char letter = str.charAt(j);
                if (!current.childNodeMap.containsKey(letter)) {
                    return false;
                }
                current = current.childNodeMap.get(letter);
            }

            return current.childNodeMap.containsKey(endSymbol);
        }
    }
}
