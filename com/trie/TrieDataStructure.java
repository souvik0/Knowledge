package com.trie;
// Trie is used for phone book & dictionary kind of data structure. 
// Also very much used data structure to build TypeAhead system.
// Search operation happens at O(L) time complexity as L stands for length of the word. This is the major
// advantage of using Trie.

public class TrieDataStructure {

    private TrieNode root;

    public TrieDataStructure() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        if (search(word)) {
            System.out.println("Already exist");
            return;
        }

        TrieNode current = root;
        for (char ch : word.toCharArray()) {
             TrieNode child = current.getChildNode(ch);
             if (child != null) {
                 current = child;
             } else {
                 current.childNodeList.add(new TrieNode(ch));
                 // Newly created node assigned to the current traversing pointer
                 current = current.getChildNode(ch);
             }
             current.count++;
        }
        // Marking last char trieNode true to signify existence of word
        current.isEnd = true;
    }

    public boolean search(String word) {
         TrieNode current = root;
         for (char ch : word.toCharArray()) {
              TrieNode child = current.getChildNode(ch);
              if (child == null) {
                  return false;
              } else {
                  current = child;
              }
         }
         // Checking existence of last character node which completing a word
         return current.isEnd == true ? true : false;
    }

    // To remove an word from trie, Need to remove last char node from trie
    public void remove(String word) {
        if (!search(word)) {
            System.out.println("No such word exist");
            return;
        }
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
             TrieNode child = current.getChildNode(ch);
             // If this node is leaf node then remove directly
             if (child.count == 1) {
                 current.childNodeList.remove(child);
             } else {
                 // Reduce count
                 child.count--;
                 current = child;
             }
        }

        /* Mark last but one char node of the word false to signify the word not present, 
           it signifies that it is not completing a word 
        */
        current.isEnd = false;
    }
}
