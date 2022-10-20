package com.lrucache;

// This class is basically representing Node of doubly linked-list
public class EntryNode<K, V> {

    public K key; // identification key

    // property representing doubly linked list
    public V data;
    public EntryNode<K, V> left;
    public EntryNode<K, V> right;
}