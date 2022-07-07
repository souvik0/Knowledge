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
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
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
            TrieNode node = root;
            for (int j= i; j < str.length(); j++) {
                 char letter = str.charAt(j);
                 if (!node.children.containsKey(letter)) {
                     TrieNode newNode = new TrieNode();
                     node.children.put(letter, newNode);
                 }
                 node = node.children.get(letter);
            }
            node.children.put(endSymbol, null);
        }

        public boolean search(String str) {
            TrieNode node = root;
            for (int j = 0; j < str.length(); j++) {
                char letter = str.charAt(j);
                if (!node.children.containsKey(letter)) {
                    return false;
                }
                node = node.children.get(letter);
            }
            return node.children.containsKey(endSymbol);
        }
    }
}
