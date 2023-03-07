package com.arrayString;

/* This is similar algorithm as quick sort. Apart from Quick sort calculates pivot element before while & check
   condition with pivot element */

public class SegregateEvenOdd {

    public static void main(String[] args) {
        int arr[] = {12, 34, 45, 9, 8, 90, 3};
        segregateEvenOdd(arr);
        System.out.print("Array after segregation: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
    }

    public static void segregateEvenOdd(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            while (arr[left] % 2 == 0) {
                left++;
            }

            while (arr[right] % 2 == 1) {
                right--;
            }

            // Swapping of elements
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                // moving the pointer to the next
                left++;
                right--;
            }
        }
    }
}
