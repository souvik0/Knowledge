package com.consitentHashing;

import java.security.NoSuchAlgorithmException;
import java.util.*;

public class ConsistentHashing {

    private final TreeMap<Long, String> ring;
    private final int numberOfReplicas;

    public static void main(String[] args) throws NoSuchAlgorithmException {
        ConsistentHashing ch = new ConsistentHashing(3);
        ch.addServer("server1");
        ch.addServer("server2");
        ch.addServer("server3");

        System.out.println("key1: is present on server: " + ch.getServer("key1")); 
        System.out.println("key67890: is present on server: " + ch.getServer("key67890")); 

        ch.removeServer("server1");
        System.out.println("After removing server1");

        System.out.println("key1: is present on server: " + ch.getServer("key1")); 
        System.out.println("key67890: is present on server: " + ch.getServer("key67890")); 
    }

    public ConsistentHashing(int numberOfReplicas) throws NoSuchAlgorithmException {
        this.ring = new TreeMap<>();
        this.numberOfReplicas = numberOfReplicas;
    }

    public void addServer(String server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            long hash = generateHash(server + i);
            ring.put(hash, server);
        }
    }

    public void removeServer(String server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            long hash = generateHash(server + i);
            ring.remove(hash);
        }
    }

    public String getServer(String key) {
        if (ring.isEmpty()) {
            return null;
        }

        long hash = generateHash(key);
        if (!ring.containsKey(hash)) {
            SortedMap<Long, String> tailMap = ring.tailMap(hash);
            hash = tailMap.isEmpty() ? ring.firstKey() : tailMap.firstKey();
        }

        return ring.get(hash);
    }

    private long generateHash(String key) {
        int result = 31;
        int prime = 17;
        int hash = result * prime + key != null ? key.hashCode() : 0;
        return hash;
    }
}
