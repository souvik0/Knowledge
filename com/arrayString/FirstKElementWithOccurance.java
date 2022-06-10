package com.arrayString;

/* Find k numbers with most occurrences in the given array
   Given an array of n numbers and a positive integer k. 
   The problem is to find k numbers with most occurrences, i.e., 
   the top k numbers having the maximum frequency. 
   If two numbers have the same frequency then the larger number should be given preference. 
   The numbers should be displayed in decreasing order of their frequencies. 
   It is assumed that the array consists of k numbers with most occurrences. */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FirstKElementWithOccurance {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        int[] arr2 = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int k = 4;

        findKOccurances(arr2, k);
    }

    // This method helping us to find out efficiently with the help of PriorityQueue
    public static void findKOccurances(int[] arr, int k) {
        // This map stores number as Key & frequency of number as value
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (hmap.containsKey(arr[i])) {
                hmap.put(arr[i], hmap.get(arr[i]) + 1);
            } else {
                hmap.put(arr[i], 1);
            }
        }

       // Create a Priority Queue to sort based on the count 
       // or on the key if the count is same 
       // Here priority queue is storing most frequent element first & then 
       // in order of integer of same frequency element
       PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<Map.Entry<Integer, Integer>> (
           (a, b) -> a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey()) :
                                                         Integer.compare(b.getValue(), a.getValue())
       );

       // Traversing over map to populate the queue
       for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
           priorityQueue.add(entry);
       }

       // Print the top k elements by looping over the queue 
       for (int i = 0; i < k; i++) {
           Map.Entry<Integer, Integer> entry = priorityQueue.poll();
           System.out.println("Elements : " + entry.getKey() + " : " + entry.getValue());
       } 
    }
}