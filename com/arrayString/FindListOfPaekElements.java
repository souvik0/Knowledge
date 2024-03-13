package com.arrayString;

import java.util.*;

public class FindListOfPaekElements {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1, 2, 4, 3, 5, 0};
        List<Integer> peakElements = findPeakElements(nums);
        System.out.println("Peak Elements: " + peakElements);
    }

    public static List<Integer> findPeakElements(int[] nums) {
        List<Integer> peaks = new ArrayList<>();

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
                (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                peaks.add(nums[mid]);
                left = mid + 1;  // Move to the right to find more peaks
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return peaks;
    }
}
