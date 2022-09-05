package com.arrayString;

public class ThreeNumberSort {

    public static void main(String[] args) {
        int arr[] = {9, 9, 9, 7, 9, 7, 9, 9, 7, 9};
        int order[] = {7, 11, 9};
        int sortedOrderedArray[] = sortArray(arr, order);
        for (int i = 0; i < sortedOrderedArray.length; i++) {
            System.out.print(sortedOrderedArray[i] + " "); 
        }
    }

    // Only needs to decide first & third order index position. Second will gets adjusted automatically.
    public static int[] sortArray(int[] arr, int[] order) {
        int firstOrderValue = order[0];
        int thirdOrderValue = order[2];

        int firstArrayIndex = 0;
        for (int index = 0; index < arr.length; index++) {
             if (arr[index] == firstOrderValue) {
                 swap(arr, firstArrayIndex, index);
                 firstArrayIndex++;
             }
        }

        int thirdArrayIndex = arr.length - 1;
        for (int index = arr.length - 1; index >= 0; index--) {
             if (arr[index] == thirdOrderValue) {
                 swap(arr, thirdArrayIndex, index);
                 thirdArrayIndex--;
             }
        }

        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
