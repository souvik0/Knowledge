package com.sorting;

import java.util.Arrays;

public class CountOfInversion {

    public static void main(String[] args) {
        int[] arr = {100, 20, 15, 30, 5, 75, 40};
        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1));
    }

    public static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        int mid = (left + right)/2;

        if (left < right) {
            // Divide left side of element of the array up to single element array creation
            count+= mergeSortAndCount(arr, left, mid);
            // Divide right side of element of the array up to single element array creation
            count+= mergeSortAndCount(arr, mid + 1, right);
            // Concur all the sub arrays
            count+= mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    public static int mergeAndCount(int[] arr, int start, int mid, int end) {
        // Left subarray
        int[] left = Arrays.copyOfRange(arr, start, mid + 1);
  
        // Right subarray
        int[] right = Arrays.copyOfRange(arr, mid + 1, end + 1);

        int i = 0, j = 0, k = start, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                // Here inversion took place
                swaps += (mid + 1) - (start + i);
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }

    return swaps;
    }
}
