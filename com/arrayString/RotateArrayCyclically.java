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
        int i = 0;
        int j = arr.length - 1;

        while (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }
    }
}
