package com.arrayString;

public class FindMaxiMinWithoutSorting {

    // Driver code
    public static void main(String[] args){
        int arr[] = { 12, 1234, 45, 67, 1 };
        int n = arr.length;
        System.out.println("Minimum element of array: " + getMin(arr, n));
        System.out.println("Maximum element of array: " + getMax(arr, n));
    }

    public static int getMin(int arr[], int n) {
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    public static int getMax(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
