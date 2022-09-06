package com.arrayString;

/* Always performs on a sorted array.
   To find out which index of the array is holding the item
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch(); 
        int arr[] = {2, 3, 4, 10, 40};
        int x = 40; 
        int result = ob.binarySearchIterative(arr, x); 
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at "+ "index " + result);
    }

    public int binarySearchIterative(int[] arr, int numberToBeSearched) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int midIndex = left + (right-left)/2;
            if (arr[midIndex] == numberToBeSearched) {
               return midIndex;
            }
            if (arr[midIndex] < numberToBeSearched) {
                left = midIndex + 1;
            }
            if (arr[midIndex] > numberToBeSearched) {
                right = midIndex -1;
            }
        }

        return -1;
    }
}