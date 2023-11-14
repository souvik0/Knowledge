package com.arrayString;

// Considering that there will always be an majority element.

public class MajorityElementsInArray {

    public static void main(String[] args) {
         int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4};
         int majorityElement = findMajorityElement(nums);

         if (majorityElement != -1) {
             System.out.println("Majority Element: " + majorityElement);
         } else {
             System.out.println("No majority element found");
         }
    }

    public static int findMajorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;

        // Moore's Voting Algorithm
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count++;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Verify if the candidate is the majority element
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return count > nums.length / 2 ? candidate : -1;
    }
}
