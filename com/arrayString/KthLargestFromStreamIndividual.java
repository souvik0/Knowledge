package com.arrayString;

import java.util.*;

public class KthLargestFromStreamIndividual {

    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargestFromStreamIndividual kthLargest = new KthLargestFromStreamIndividual(k, nums);

        System.out.println(kthLargest.add(3)); // Output: 4
        System.out.println(kthLargest.add(5)); // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9)); // Output: 8
        System.out.println(kthLargest.add(4)); // Output: 8
    }

    // To populate priority queue initially with array elements
    public KthLargestFromStreamIndividual(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else {
            if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }
        }

        return minHeap.peek();
    }
}
