package com.sorting;

public class CountOfInversion {

    public static void main(String[] args) {
        int[] arr = {100,20,15,30,5,75,40};
        System.out.println(mergeSortAndCount(arr, 0, arr.length));
    }

    public static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = left + (right-left)/2;
            // Divide left side of element of the array up to single element array creation
            count+= mergeSortAndCount(arr, left, mid);
            // Divide right side of element of the array up to single element array creation
            count+= mergeSortAndCount(arr, mid + 1, right);
            // Concur all the sub arrays
            count+= mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    public static int mergeAndCount(int[] arr, int start, int mid, int end) {
        int[] tempArray = new int[arr.length];
        int tempArrayStartIndex = start;
        int inversion = 0;

        // For original array
        int startIndex = start;
        int midIndex = mid + 1;

        while (startIndex <= mid && midIndex <= end) {
            // Need to compare each element starting from 0th index of the given array to fill up tempArray
            if (arr[startIndex] < arr[midIndex]) {
                tempArray[tempArrayStartIndex] = arr[startIndex];
                tempArrayStartIndex++;
                startIndex++;
            } else {
                tempArray[tempArrayStartIndex] = arr[midIndex];
                tempArrayStartIndex++;
                midIndex++;
                inversion++;
            }
        }

        // Adjust rest of the elements
        while (startIndex <= mid) {
            tempArray[tempArrayStartIndex] = arr[startIndex];
            tempArrayStartIndex++;
            startIndex++;
        }

        while (midIndex <= end) {
            tempArray[tempArrayStartIndex] = arr[midIndex];
            tempArrayStartIndex++;
            midIndex++;
        }

        // Copy tempArray to actual array after sorting 
        for (int i = start; i <= end; i++) {
             arr[i] = tempArray[i];
        }

        return inversion;
    }

}
