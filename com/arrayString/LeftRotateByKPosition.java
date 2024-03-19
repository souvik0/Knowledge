package com.arrayString;

public class LeftRotateByKPosition {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        leftRotateByK(nums, k);
        System.out.println("Array after left rotation by " + k + " positions:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void leftRotateByK(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // To handle cases where k > n
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
