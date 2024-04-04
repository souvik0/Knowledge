package com.arrayString;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {-1, -3, -10, 0, 60};
        int maxProduct = maxProduct(nums);
        System.out.println("Maximum Product Subarray: " + maxProduct);
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        // Initialize variables to keep track of the maximum and minimum product ending at the current position
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            // Swap maxProduct and minProduct if the current element is negative
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Update maxProduct and minProduct for the current position
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);
            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
