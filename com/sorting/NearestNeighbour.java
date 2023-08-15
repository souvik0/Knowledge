package com.sorting;

public class NearestNeighbour {

    public static void main(String[] args) {
        int[] arr = {2, 7, 15, 25, 30};
        int target = 17;
        int nearest = findNearest(arr, target);
        System.out.println("The nearest element to " + target + " is: " + nearest);
    }

    public static int findNearest(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("The input array is null or empty.");
        }

        int nearest = arr[0];
        int minDifference = Math.abs(target - nearest);

        for (int i = 1; i < arr.length; i++) {
            int currentDifference = Math.abs(target - arr[i]);
            if (currentDifference < minDifference) {
                nearest = arr[i];
                minDifference = currentDifference;
            }
        }

        return nearest;
    }
}
