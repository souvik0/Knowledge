package com.lrucache;
/* LRU is a cache eviction policy
/* Doubly linked list is used to maintain put operation at O(1) & 
 * Hash map used to maintain get operation at O(1).
 */

import java.util.HashMap;
import java.util.Map;

import javax.swing.text.Position;

public class LRUCache<K, V> {

    private Map<K, EntryNode<K, V>> tempMap; // Temporary hash map to maintain get operation at O(1)
    private EntryNode<K, V> start, end; // Start & End pointer for doubly linked-list
    private int LRU_SIZE = 4;

    @SuppressWarnings("unchecked")
    public LRUCache() {
        start = end = null;
        tempMap = (HashMap<K, EntryNode<K, V>>) new HashMap<K, V>();
    }

    @SuppressWarnings("unchecked")
    public LRUCache(int capacity) {
        start = end = null;
        this.LRU_SIZE = capacity;
        tempMap = (HashMap<K, EntryNode<K, V>>) new HashMap<K, V>();
    }

    public void putEntry(K key, V data) {
        /* if already entry object exist, then update the value of entry object with new value & 
           remove the node from it's current position in doubly linked list.
           As this point of time entry object node becomes least recently accesses, So put this at the starting of
           doubly linked list. 
        */
        if (tempMap.containsKey(key)) {
            EntryNode<K, V> entry = tempMap.get(key);
            removeNode(entry);
            entry.data = data;
            addAtFirst(entry);
            // no need to put separately in tempMap as the entry object is already there in map.
        } else {
            // Create new entry object
            EntryNode<K, V> newEntryObject = new EntryNode<K, V>();
            newEntryObject.left = null;
            newEntryObject.right = null;
            newEntryObject.key = key;
            newEntryObject.data = data;

            // Validate against LRU cache size
            if (tempMap.size() >= LRU_SIZE) {
                // Removing end node from temporary map as well from the doubly linked list
                tempMap.remove(end.key);
                removeNode(end);
                // Add the newEntry at first as it is most recently accessed
                addAtFirst(newEntryObject);
            } else {
                // Add the newEntry at first as it is most recently accessed
                addAtFirst(newEntryObject);
            }

            // Irrespective of size check have to put entry object to map
            tempMap.put(key, newEntryObject);
        }
    }

    public V getEntry(K key) {
        if (tempMap.containsKey(key)) {
            EntryNode<K, V> entry = tempMap.get(key);
            //As this object becomes last accessed, so remove it's from it's current position in linked list
            removeNode(entry);
            //Add this object as first node in linked list
            addAtFirst(entry);
            return entry.data;
        }
        return null;
    }

    public void addAtFirst(EntryNode<K, V> newEntryObject) {
        // If the node is not the first entry in the linked list
        if (start != null) {
            start.left = newEntryObject;
            newEntryObject.right = start;
            start = newEntryObject;
        } else {
            start = end = newEntryObject;
        }
    }

    public void removeNode(EntryNode<K, V> node) {
        // Below if-else block specify first/middle node to be removed
        if (node.left != null) {
            node.left.right = node.right;
        } else {
            /* If it is first node of the linked list to be removed. So start pointer will move
               to next Position 
            */
            start = start.right;
        }

        // Below if-else block specify last/middle node to be removed
        if (node.right != null) {
            node.right.left = node.left;
        // If it is last node of the linked list to be removed
        } else {
            end = end.left;
        }
    }
}
