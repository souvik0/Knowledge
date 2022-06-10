package com.arrayString;

public class MaximumSubArray {

    public static void main(String[] args) {
        int arr[] = {-2, -1, 13, -2, -3, 6, 8};
        System.out.println("Maximum subarray : " + maximumSubArray(arr));
    }

    public static int maximumSubArray(int[] arr) {
        int max_so_far = arr[0];
        int curr_sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curr_sum = curr_sum + arr[i];
            // Calculate maximum current sum for particular iteration
            curr_sum = Math.max(arr[i], curr_sum);
            // Finding out maximum sum so far including all iteration
            max_so_far = Math.max(max_so_far, curr_sum); 
        }

        return max_so_far; 
    }
}
// To find maximum sub array range, can be used sub array with negetive number approach.