package com.arrayString;

// Find minimum difference between sum & the given sum to get the closest sum & then find pair
// THis operation will be performed after sorting the array
import java.util.Arrays;

public class FindPairsClosestToGivenSum {

    public static void main(String[] args) {
        int arr[] = {10, 22, 28, 29, 30, 40};
        int x = 54;
        findPairs(arr, x);
    }

    public static void findPairs(int[] arr, int givenSum) {
        int left = 0;
        int right = arr.length - 1;
        int minleft = 0, minright = 0;
        // To find closest difference is needed to calculate
        int minDiff = Integer.MAX_VALUE;

        Arrays.sort(arr);

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            int diff = (currentSum - givenSum);
            if (Math.abs(diff) < Math.abs(minDiff)) {
                minDiff = diff;
                minleft = left;
                minright = right;
                System.out.println("Left: " + arr[minleft] + " : right: " + arr[minright]);
            }
            if (currentSum > givenSum) {
                right--;
            }
            if (currentSum < givenSum) {
                left++;
            }
        }
    }
}