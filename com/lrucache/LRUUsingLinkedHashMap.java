package com.lrucache;

/* Access order needs to be maintained. to get things at par with LRUCache to get
 * least recently accessed object first
 */
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUUsingLinkedHashMap<K, V> extends LinkedHashMap<K, V>
       implements Serializable {

    private static final long serialVersionUID = -1L;
    int capacity;

    public LRUUsingLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true); // True for access order, false for insertion order
        this.capacity = capacity;
    }

    // This method works in O(1)
    public V getEntry(K key) {
        return super.get(key);
    }

    // This method works in O(1)
    public void putEntry(K key, V value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUUsingLinkedHashMap<Integer, Integer> lrucache = new LRUUsingLinkedHashMap<Integer, Integer>(4);
        lrucache.putEntry(1, 100);
        lrucache.putEntry(10, 99);
        lrucache.putEntry(15, 98);
        lrucache.putEntry(10, 97);
        lrucache.putEntry(12, 96);
        lrucache.putEntry(18, 95);
        lrucache.putEntry(1, 94);
        System.out.println(lrucache.getEntry(1));
        System.out.println(lrucache.getEntry(10));
        System.out.println(lrucache.getEntry(15));
    }
}
