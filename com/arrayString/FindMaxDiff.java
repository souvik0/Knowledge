package com.arrayString;

// Here larger number is always appearing after smaller number
// It also cater leader in array problem
public class FindMaxDiff {

    public static void main(String[] args) {
        int arr[] = {1, 120, 90, 10, 110};
        System.out.println(findMaxDiff(arr));
    }

    public static int findMaxDiff(int[] arr) {
        int maxDiff = Integer.MIN_VALUE;
        // Considering right most element as max element
        int maxRight = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > maxRight) {
               maxRight = arr[i];
            } else {
                int diff = maxRight - arr[i];
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }

        return maxDiff;
    }
}