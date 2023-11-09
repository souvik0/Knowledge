package com.arrayString;

import java.util.*;

public class SubarrayWithZeroSum {

    public static void main(String[] args) {
        int[] nums = {4, 2, -3, 1, 6};
        boolean hasZeroSumSubarray = hasZeroSumSubarray(nums);
        System.out.println("Has zero sum subarray: " + hasZeroSumSubarray);
    }

    public static boolean hasZeroSumSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : nums) {
            sum += num;
            // If the sum is zero or already exists in the set, there is a zero sum subarray
            if (sum == 0 || set.contains(sum)) {
                return true;
            }
            // Add the cumulative sum to the set
            set.add(sum);
        }

        // No zero sum subarray found
        return false;
    }
}
