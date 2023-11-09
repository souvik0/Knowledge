package com.arrayString;

public class MinJumpsRequired {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        int minJumps = findMinJumps(nums);
        System.out.println("Minimum Jumps: " + minJumps);
    }

    public static int findMinJumps(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int n = nums.length;
        int maxReach = nums[0]; // Maximum index that can be reached from the current position
        int steps = nums[0]; // Steps remaining at the current position
        int jumps = 1; // Number of jumps needed to reach the end

        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                return jumps; // Reached the end
            }

            maxReach = Math.max(maxReach, i + nums[i]);
            steps--;

            if (steps == 0) {
                jumps++;

                // Check if it's possible to reach the end from the current position
                if (i >= maxReach) {
                    return -1; // Cannot reach the end
                }

                steps = maxReach - i;
            }
        }

        return -1; // If the end is not reached
    }
}
