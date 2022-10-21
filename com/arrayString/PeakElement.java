package com.arrayString;

/* O(log n) time complexity
   This problem can be solved with leader in array approach also, 
   but that imposes O(n) time complexity for worst case.
   This algorithm applies for strictly increasing or decreasing order array.
 */

public class PeakElement { 
    // A binary search based function 
    // that returns index of a peak element 
    public static int findPeakUtil(int arr[], int left, int right, int n) {
        // Find index of middle element 
        // (low + high)/2 
        int mid = left + (right - left)/2;

        // Compare middle element with its neighbors (if neighbors exist) 
        if ((mid == 0 || arr[mid - 1] < arr[mid]) &&
            (mid == n - 1 || arr[mid + 1] < arr[mid])) {
            return mid;
        }

        /* If middle element is not peak and its left neighbor is greater than it, then left half 
           must have a peak element
        */ 
        else if (mid > 0 && arr[mid - 1] > arr[mid]) {
            return findPeakUtil(arr, left, (mid - 1), n);
        }

        /* If middle element is not peak and its right neighbor is greater than it, then right
           half must have a peak element
        */
        else {
            return findPeakUtil(arr, (mid + 1), right, n);
        }
    }

    // A wrapper over recursive function 
    public static int findPeak(int arr[], int n) {
        int left = 0;
        int right = n-1;
        return findPeakUtil(arr, left, right, n);
    }

    public static void main(String[] args) { 
        int arr[] = {10, 20, 15, 2, 23, 90, 67};
        int n = arr.length; 
        System.out.println("Index of a peak point is " + findPeak(arr, n));
        System.out.println("Peak element: " + arr[findPeak(arr, n)]);
    } 
}