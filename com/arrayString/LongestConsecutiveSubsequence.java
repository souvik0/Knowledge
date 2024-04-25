package com.arrayString;

import java.util.*;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int[] nums = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
        int longestConsecutiveLength = longestConsecutive(nums);
        System.out.println("Longest Consecutive Subsequence Length: " + longestConsecutiveLength);
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Check if the current number is already present or not.
            // If not then it is becoming the starting point of the sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Extend the sequence as long as consecutive numbers are present
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
