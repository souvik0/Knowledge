package com.arrayString;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementFromArray {

    public static void main(String[] args) {
        int[] nums = {98, 23, 54, 12, 20, 7, 27};
        System.out.println(Arrays.toString(findNextGreaterElement(nums)));
    }

    public static int[] findNextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the input array from right to left
        // and find the next greater element for each element
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack while the current element is greater than the top of the stack
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }

            // Set the next greater element for the current element
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                // If there is no next greater element, set the result to -1
                result[i] = -1;
            }

            // Push the current element onto the stack
            stack.push(nums[i]);
        }

        return result;
    }
}
