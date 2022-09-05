package com.sorting;

// Finding out median from stream of input

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Insert & re-balance every time starting from the max heap.
 * This way we only allow number of element difference between maxHeap & minHeap to be 1 max.
 * When the number of element is odd, then minHeap will have 1 extra element
 * If both heaps having same number of element or element count is odd, then average of peeks of both
 * the heap becomes the median.
 */
public class ContinuousMedian {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        System.out.println("Median after inserting 5: " + insert(5, minHeap, maxHeap));
        System.out.println("Median after inserting 15: " + insert(15, minHeap, maxHeap));
        System.out.println("Median after inserting 1: " + insert(1, minHeap, maxHeap));
    }

    public static Double insert(int element, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        Double median = 0.0;

        if (minHeap.size() == maxHeap.size()) {
            minHeap.add(element);
        } else {
            minHeap.add(element);
            maxHeap.add(minHeap.remove());
        }

        median = getMedian(minHeap, maxHeap);
        return median;
    }

    public static Double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0.0;
        }
        return minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek())/2.0 :
                                                   minHeap.peek();
    }
}
