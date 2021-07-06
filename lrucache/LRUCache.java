package com.lrucache;
/* LRU is a cache eviction policy
/* Doubly linked list is used to maintain put operation at O(1) & 
 * Hash map used to maintain get operation at O(1).
 */

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer, EntryNode> tempMap; // Temporary hash map to maintain get operation at O(1)
    private EntryNode start, end; // Start & End pointer for doubly linked-list
    private int LRU_SIZE = 4;

    public LRUCache() {
        start = end = null;
        tempMap = new HashMap<Integer, EntryNode>();
    }

    public LRUCache(int capacity) {
        start = null;
        end = null;
        this.LRU_SIZE = capacity;
        tempMap = new HashMap<Integer, EntryNode>();
    }

    public void putEntry(int key, int data) {
        /* if already entry object exist, then update the value of entry object with new value & 
           remove the node from it's current position in doubly linked list.
           As this point of time entry object node becomes least recently accesses, So put this at the starting of
           doubly linked list. 
        */
        if (tempMap.containsKey(key)) {
            EntryNode entry = tempMap.get(key);
            entry.data = data;
            removeNode(entry);
            addAtFirst(entry);
            // no need to put separately in tempMap as the entry object is already there in map.
        } else {
            // Create new entry object
            EntryNode newEntryObject = new EntryNode();
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

    public int getEntry(int key) {
        if (tempMap.containsKey(key)) {
            EntryNode entry = tempMap.get(key);
            //As this object becomes last accessed, so remove it's from it's current position in linked list
            removeNode(entry);
            //Add this object as first node in linked list
            addAtFirst(entry);
            return entry.data;
        }
        return -1;
    }

    public void addAtFirst(EntryNode newEntryObject) {
        //If the node is not the first entry in the linked list
        if (start != null) {
            start.left = newEntryObject;
            newEntryObject.right = start;
            start = newEntryObject;
        } else {
            start = newEntryObject;
            end = start;
        }
    }

    public void removeNode(EntryNode node) {
        // Below if-else block specify first/middle node to be removed
        if (node.left != null) {
            node.left.right = node.right;
        // If it is first node of the linked list to be removed
        } else {
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
