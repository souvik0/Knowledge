package com.arrayString;

public class RainwaterTrapping {

    public static void main(String[] args) {
        int[] height = {3, 0, 2, 0, 4};
        int trappedWater = trap(height);
        System.out.println("Amount of trapped water: " + trappedWater);
    }

    public static int trap(int[] height) {
        int n = height.length;

        if (n <= 2) {
            return 0; // No water can be trapped with less than 3 bars
        }

        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                trappedWater += leftMax - height[left];
                left++;
            } else {
                trappedWater += rightMax - height[right];
                right--;
            }
        }

        return trappedWater;
    }
}
