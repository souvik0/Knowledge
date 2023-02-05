package com.arrayString;

import java.util.ArrayList;

/* Time Complexity : O(nlogn)

 * logn factor is coming because of additional sorting introduced in first approach.
 * hashing based approach doesn't have this additional complexity
 * This problem can be extended to find triplet sum also.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairsEqualsToGivenSum {

    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 3, 45, 6, 10, -8};
        findPairs(arr, 5);
        findPairsByHashing(arr, 5);
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);
        numbers.add(3);
        numbers.add(45);
        numbers.add(6);
        numbers.add(10);
        numbers.add(-8);
        List<Integer> indexList = pair_sum_sorted_array(numbers, 5);
        System.out.println("IndexList stands as : " +indexList.toString());
    }

    // With sorted array approach
    public static void findPairs(int[] arr, int givenSum) {
        int left = 0;
        int right = arr.length - 1;

        // Introduces log(n) time complexity
        Arrays.sort(arr);

        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == givenSum) {
                System.out.println("Left: " + arr[left] + " : right: " + arr[right]);
                left++;
                right--;
            }

            if (currentSum > givenSum) {
                right--;
            }

            if (currentSum < givenSum) {
                left++;
            }
        }
    }

    // More efficient algorithm to avoid extra sorting.
    // It will also takes care of negetive sum
    public static void findPairsByHashing(int[] arr, int givenSum) {
        Set<Integer> hset = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
             int temp = givenSum - arr[i];
             if (hset.contains(temp)) {
                 System.out.println("Pairs are : " + temp + " & " + arr[i]);
                 break;
             }
             hset.add(arr[i]);
        }
    }
}
