package com.arrayString;

import java.util.*;

public class FindListOfPaekElements {

    public static void main(String[] args) {
        int nums[] = {1, 4, 3, 6, 7, 5};
        List<Integer> peakElements = findPeakElements(nums);
        System.out.println("Peak Elements: " + peakElements);
    }

    public static List<Integer> findPeakElements(int[] nums) {
        List<Integer> peakElements = new ArrayList<>();

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peakElements.add(nums[i]);
            }
        }

        return peakElements;
    }
}
