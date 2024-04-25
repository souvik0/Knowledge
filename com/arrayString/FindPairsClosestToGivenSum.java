package com.arrayString;

// Find minimum difference between sum & the given sum to get the closest sum & then find pair
// THis operation will be performed after sorting the array
import java.util.Arrays;

public class FindPairsClosestToGivenSum {

    public static void main(String[] args) {
        int[] nums = {1, 60, -10, 70, -80, 85};
        int target = 0;
        int[] closestPair = findClosestPair(nums, target);
        System.out.println("The closest pair to " + target + " is [" +
                           closestPair[0] + ", " + closestPair[1] + "]");
    }

    public static int[] findClosestPair(int[] nums, int target) {
        int n = nums.length;
        if (n < 2) {
            return new int[]{};  // Edge case: not enough elements to form a pair
        }

        Arrays.sort(nums);  // Sort the array to use two-pointer technique
        int left = 0;
        int right = n - 1;
        int closestSum = nums[left] + nums[right];
        int closestLeft = left;
        int closestRight = right;

        while (left < right) {
            int currentSum = nums[left] + nums[right];

            // Update the closest sum if the current one is closer to the target
            if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                closestSum = currentSum;
                closestLeft = left;
                closestRight = right;
            }

            // Move pointers to try to get closer to the target sum
            if (currentSum < target) {
                left++;
            } else if (currentSum > target) {
                right--;
            } else {
                break;  // The current sum is exactly the target
            }
        }

        return new int[] {nums[closestLeft], nums[closestRight]};
    }
}
