package com.arrayString;

import java.util.Arrays;

public class PrintTripletsToClosestSum {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = -2;
        int[] closestTriplet = threeSumClosest(nums, target);
        System.out.println("The closest triplet to target " + target + " is [" +
            closestTriplet[0] + ", " + closestTriplet[1] + ", " + closestTriplet[2] + "]");
    }

    public static int[] threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        int[] closestTriplet = new int[] {nums[0], nums[1], nums[2]}; // Initial triplet

        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                // Update the closest sum and the result triplet if the current sum is closer
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                    closestTriplet[0] = nums[i];
                    closestTriplet[1] = nums[left];
                    closestTriplet[2] = nums[right];
                }

                // Adjust pointers based on comparison of currentSum and target
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    break;
                    //return new int[]{nums[i], nums[left], nums[right]}; // Exact match
                }
            }
        }

        return closestTriplet; // Closest triplet
    }
}
