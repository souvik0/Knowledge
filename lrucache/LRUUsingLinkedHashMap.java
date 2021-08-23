package lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUUsingLinkedHashMap {

    private LinkedHashMap<Integer, Integer> cacheMap;

    public LRUUsingLinkedHashMap(int capacity) {
        cacheMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            private static final long serialVersionUID = 1L;
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    // This method works in O(1)
    public int get(int key) {
        return cacheMap.getOrDefault(key, -1);
    }

    // This method works in O(1)
    public void set(int key, int value) {
        cacheMap.put(key, value);
    }

    public static void main(String[] args) {
        LRUUsingLinkedHashMap lrucache = new LRUUsingLinkedHashMap(4);
        lrucache.set(1, 100);
        lrucache.set(10, 99);
        lrucache.set(15, 98);
        lrucache.set(10, 97);
        lrucache.set(12, 96);
        lrucache.set(18, 95);
        lrucache.set(1, 94);
        System.out.println(lrucache.get(1));
        System.out.println(lrucache.get(10));
        System.out.println(lrucache.get(15));
    }
}
