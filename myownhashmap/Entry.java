package com.myownhashmap;

/* This class is basically representing Node of singly linked-list
 * In case of hashmap this entry object represents singly linked list 
 */
public class Entry<K, V> {

    private final K key;
    private volatile V value;
    //Creates Singly LinkedList of Entry Objects
    private Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value =value;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }
}