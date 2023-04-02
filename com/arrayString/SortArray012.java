package com.arrayString;

// This problem also known as Dutch national flag problem.
public class SortArray012 {

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sortArray(arr);
    }

    public static void sortArray(int[] arr) {
        int left = 0;
        int countOfZero = 0;
        int countOfOne = 0; 
        int countOfTwo = 0;

        for (int i = 0; i < arr.length; i++) {
             switch(arr[i]) {
             case 0:
                 countOfZero++;
                 break;
             case 1:
                 countOfOne++;
                 break;
             case 2:
                 countOfTwo++;
                 break;
             }
        }

        while (countOfZero > 0) {
            arr[left] = 0;
            left++;
            countOfZero--;
        }

        while (countOfOne > 0) {
            arr[left] = 1;
            left++;
            countOfOne--;
        }

        while (countOfTwo > 0) {
            arr[left] = 2;
            left++;
            countOfTwo--;
        }

        printArray(arr);
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}