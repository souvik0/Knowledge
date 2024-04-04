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
        swap(nums, 0, k - 1); // Swapping of elements
        swap(nums, k, n - 1);
        swap(nums, 0, n - 1);
    }

    private static void swap(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
