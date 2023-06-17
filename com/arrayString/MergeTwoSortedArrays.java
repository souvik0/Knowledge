package com.arrayString;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 20};
        int n1 = arr1.length;
        int[] arr2 = {2, 4, 6, 8, 11, 51};
        int n2 = arr2.length;
        int[] arr = mergeArrays(arr1, arr2, n1, n2);
        System.out.println("Array after merging");

        for (int i=0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2, int n1, int n2) {
        int i = 0; // index of arr1
        int j = 0; // index of arr2
        int k = 0; // index of merged array

        int[] mergedArray = new int[n1 + n2];

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else if (arr2[j] < arr1[i]){
                mergedArray[k++] = arr2[j++];
            }
        }

        // Handle rest of the elements of arr1
        while (i < n1) {
            mergedArray[k++] = arr1[i++];
        }

        // Handle rest of the elements of arr2
        while (j < n2) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }
}