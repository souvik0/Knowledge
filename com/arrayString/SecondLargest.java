package com.arrayString;

public class SecondLargest {

    public static void main(String[] args) {
        int arr[] = {12, 35, 1, 10, 34, 1};
        System.out.println("Second Largest number :" + secondLargest(arr));
    }

    public static int secondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
             if (arr[i] > largest) {
                 secondLargest = largest;
                 largest = arr[i];
             }
             // Handle duplicate entries of largest number condition also
             if (arr[i] > secondLargest && arr[i] != largest) {
                 secondLargest = arr[i];
             }
        }

        return secondLargest;
    }
}
