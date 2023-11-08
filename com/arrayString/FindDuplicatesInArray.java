package com.arrayString;

// This solution helps to determine duplicate with 0(1) space complexity.

import java.util.List;
import java.util.ArrayList;

public class FindDuplicatesInArray {

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println("Duplicates: " + duplicates);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Phase 1: Detect cycle using Floyd's Tortoise and Hare algorithm
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle (duplicate element)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        result.add(slow); // Add the duplicate element to the result

        return result;
    }
}
