package com.trie;
// Standard Trie definition
import java.util.LinkedList;
import java.util.List;

public class TrieNode {

    char data;
    // Count will represent if the node is leaf node or not. If count is 1, then it is leaf node
    int count;
    // isEnd is used to represent a valid word constructed by the letters
    boolean isEnd;
    // A single Trie node will have multiple child. Will be represented through collection.
    List<TrieNode> childNodeList;

    public TrieNode(char data) {
        this.data = data;
        count = 0;
        isEnd = false;
        childNodeList = new LinkedList<TrieNode>();
    }

    public TrieNode getChildNode(char data) {
        if (childNodeList != null) {
            for (TrieNode eachChild : childNodeList) {
                 if (eachChild.data == data) {
                     return eachChild;
                }
            }
        }
        return null;
    }
}
