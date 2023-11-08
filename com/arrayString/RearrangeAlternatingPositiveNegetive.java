package com.arrayString;

public class RearrangeAlternatingPositiveNegetive {

    public static void main(String[] args) {
        int[] nums = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        rearrangeAlternating(nums);
        // Print the modified array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void rearrangeAlternating(int[] nums) {
        int n = nums.length;

        int positiveIndex = 0;
        int negativeIndex = 0;

        // Find the first positive or negative element
        while (positiveIndex < n && nums[positiveIndex] >= 0) {
            positiveIndex++;
        }

        while (negativeIndex < n && nums[negativeIndex] < 0) {
            negativeIndex++;
        }

        // Perform alternating positive and negative rearrangement
        while (positiveIndex < n && negativeIndex < n) {
            swap(nums, positiveIndex, negativeIndex);

            // Move positiveIndex to the next positive element
            positiveIndex += 2;
            while (positiveIndex < n && nums[positiveIndex] >= 0) {
                positiveIndex++;
            }

            // Move negativeIndex to the next negative element
            negativeIndex += 2;
            while (negativeIndex < n && nums[negativeIndex] < 0) {
                negativeIndex++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
