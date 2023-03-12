package com.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestFromStream {

    public static PriorityQueue<Integer> min;
    public static PriorityQueue<Integer> min_ik = new PriorityQueue<Integer>();

    public static void main(String[] args) {
        min = new PriorityQueue<Integer>();
        int k = 3;
        int arr[] = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> initial_stream = new ArrayList<Integer>();
        initial_stream.add(4);
        initial_stream.add(6);
        ArrayList<Integer> append_stream = new ArrayList<Integer>();
        append_stream.add(5);
        append_stream.add(2);
        append_stream.add(20);
        kth_largest(2, initial_stream, append_stream);
        // Function call
        List<Integer> res = getAllKthNumber(arr, k);

        for (int x : res) {
             System.out.println("Kth largest element is " + x);
        }
    }

    public static List<Integer> getAllKthNumber(int[] arr, int k) {

        // list to store kth largest number
        List<Integer> list = new ArrayList<>();

        // one by one adding values to the min heap
        for (int val : arr) {
             // if the heap size is less than k , we add to
             // the heap
             if (min.size() < k) {
                 min.add(val);
             }

             /* otherwise, first we compare the current value with the max heap TOP value
              * if TOP val > current element, no need to remove TOP, because it will be
              * the largest kth element anyhow.
              * else we need to update the kth largest element
              * by removing the top lowest element 
              */
             else {
                 if (min.peek() < val ) {
                     min.poll();
                     min.add(val);
                 }
             }

             // if the heap size >= k we add kth largest element, otherwise -1
             if (min.size() >= k) {
                 list.add(min.peek());
             } else {
                 list.add(-1);
             }
        }

        return list;
    }

    static ArrayList<Integer> kth_largest(Integer k, ArrayList<Integer> initial_stream, ArrayList<Integer> append_stream) {
        ArrayList<Integer> finalList = new ArrayList<>();

        for (Integer val : initial_stream) {
            min_ik.add(val);
        }

        for (Integer val : append_stream) {
            if (min_ik.size() < k) {
                min_ik.add(val);
             } else {
                 if (min_ik.peek() < val ) {
                     min_ik.poll();
                     min_ik.add(val);
                 }
             }
             if (min_ik.size() >= k) {
                 finalList.add(min_ik.peek());
             } else {
                 finalList.add(-1);
             }
        }

        return finalList;
    }
}
