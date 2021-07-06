package com.arrayString;

public class ArrayReversal {

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40}; 
        reverseArray(arr);
        for (int i = 0 ; i < arr.length; i++) {
             System.out.println(arr[i]);
        }
    }

    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
