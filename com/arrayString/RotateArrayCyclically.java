package com.arrayString;

import java.util.Arrays;

public class RotateArrayCyclically {

    /* Driver program */
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5};
        System.out.println("Given Array is");
        System.out.println(Arrays.toString(arr));
        rotate(arr);
        System.out.println("Rotated Array is");
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left != right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
        }
    }
}
