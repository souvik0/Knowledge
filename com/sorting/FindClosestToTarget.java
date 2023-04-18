package com.sorting;

public class FindClosestToTarget {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 6, 8, 8, 9};
        int n = arr.length;
        int target = 7;
        System.out.println(findClosestRecursive(arr, 0, n - 1, target));
    }

    public static int findClosestRecursive(int[] arr, int left, int right, int target) {

        if (left == right) {
            return arr[left];
        }
        int mid = (left + right)/2;

        int leftClosest = findClosestRecursive(arr, left, mid, target);
        int rightClosest = findClosestRecursive(arr, mid + 1, right, target);

        if (Math.abs(leftClosest - target) < Math.abs((rightClosest - target))) {
            return leftClosest;
        } else {
            return rightClosest;
        }
    }
}
