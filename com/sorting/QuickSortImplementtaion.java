package com.sorting;

/* 
 * Worst case: O(n^2)
 * Average case: O(nlogn)
 * Best Case: O(n)
*/
// This is almost similar kind of approach as binary search/ Quickselect

import java.util.Arrays;

public class QuickSortImplementtaion {

    public static void main(String a[]){
        int[] inputArray = {33,21,45,64,55,34,11,8,3,5,1};
        System.out.println("Before Sorting: ");
        System.out.println(Arrays.toString(inputArray));

        sort(inputArray);

        System.out.println("==================");
        System.out.println("After Sorting: ");
        System.out.println(Arrays.toString(inputArray));
     }

    public static void sort(int[] inputArray) {
        int left = 0;
        int right = inputArray.length - 1;
        quickSort(inputArray, left, right);
    }

    public static void quickSort(int[] inputArray, int left, int right) {
        int i = left;
        int j = right;

        // Considering pivot element as mid element
        int pivotElement = inputArray[left + (right-left)/2];

        while (i <= j) {
            while (inputArray[i] < pivotElement) {
                i++;
            }
            while (inputArray[j] > pivotElement) {
                j--;
            }
            if (i <= j) {
                inputArray = exchange(inputArray, i, j);
                // after swapping increment & decrement the index for next element check
                i++;
                j--;
            }
        }

        // Process sorting on rest of the elements
        if (left < j) {
            quickSort(inputArray, left, j);
        }

        if (i < right) {
            quickSort(inputArray, i, right);
        }
    }

    public static int[] exchange(int[] inputArray, int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
        return inputArray;
    }
}