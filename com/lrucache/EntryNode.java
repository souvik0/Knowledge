package com.lrucache;

// This class is basically representing Node of doubly linked-list
public class EntryNode<K, V> {

    K key; // identification key

    // property representing doubly linked list
    V data;
    EntryNode<K, V> left;
    EntryNode<K, V> right;
}