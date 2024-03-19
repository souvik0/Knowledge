package com.sorting;

import java.util.*;

public class TopKFrequentElementFromStringArray {

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "banana", "orange", "apple"};
        int k = 2;
        List<String> topKFrequentWords = topKFrequent(words, k);
        System.out.println("Top " + k + " frequent elements: " + topKFrequentWords);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        // Create a HashMap to count the occurrences of each word
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<Map.Entry<String, Integer>>(
        (a, b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) :
                                                      Integer.compare(b.getValue(), a.getValue())
        );

        // Add words to the priority queue
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.offer(entry);
        }

        // Build the result list
        List<String> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
             result.add(maxHeap.poll().getKey());
        }

        return result;
    }
}
