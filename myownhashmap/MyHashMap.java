package myownhashmap;

import java.io.Serializable;

public class MyHashMap<K, V> implements Serializable {

    private static final long serialVersionUID = 1L;
    private int DEFAULT_BUCKET_SIZE = 20;
    private transient Entry<K, V>[] table; // This is the bucket

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new Entry[DEFAULT_BUCKET_SIZE];
    }

    @SuppressWarnings("unchecked")
    public MyHashMap(int capacity) {
        table = new Entry[capacity];
    }

    public V get(K key) {
        if (key == null) {
            Entry<K, V> entryAtZeroIndex = table[0];
            return entryAtZeroIndex.getValue();
        }

        int tableIndex = getBucketIndexForKey(key);
        Entry<K, V> entry = table[tableIndex];

        /* Here traversing over every linked list element.
         * A bucket location can contain multiple entry objects in LinkedList format
         * Null check is to check if we reached at the last of internal LinkedList or not 
         */
        while (entry != null && !key.equals(entry.getKey())) {
            entry = entry.getNext();
        }

        return entry != null ? entry.getValue() : null;
    }

    public void put(K key, V value) {
        if (key == null) {
            putForNullKey(key, value);
            return;
        }

        int tableIndex = getBucketIndexForKey(key);
        Entry<K, V> entry = table[tableIndex];

        if (null != entry) {
            boolean done = false;
            while (!done) {
                // Replacing existing value by new key
                if (key.equals(entry.getKey())) {
                    entry.setValue(value);
                    done = true;
                // Adding new Entry object as new node in LinkedList
                } else if (entry.getNext() == null) {
                     entry.setNext(new Entry<K, V>(key, value));
                     done = true;
                } else {
                    // Otherwise keep looping over through the internal LinkedList
                    entry = entry.getNext();
                }
            }
        } else {
             // Nothing there at all; just save the new entry in designated bucket index
             table[tableIndex] = new Entry<K, V>(key, value);
        }
    }

    public int getBucketIndexForKey(K key) {
        return key.hashCode() % table.length;
    }

    private void putForNullKey(K key, V value) {
        table[0] = new Entry<K, V>(key, value);
    }
}
