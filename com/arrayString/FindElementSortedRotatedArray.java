package com.arrayString;
/*Shifted Binary Search */

/* Time Complexity: O(logN)
 * Space Complexity: O(1)
 */

/*Using Binary Search:
    Step 1: Find index of pivot element (Index of minimum element)
    Step 2: Apply Binary Search on the sub array based on following conditions:
        1. If number lies between start element and element at pivot-1 position, then find number in array[start..pivot-1] using binary search
        2. Else if number lies between pivot and last element, then find number in array[pivot..end] using binary search */
/* Algorithm for finding index of pivot element (Minimum element):
    1. If array[0] <= array[length of array - 1], it means the array is not rotated, so return 0.
    2. Initialize start = 0, end = length of array - 1.
    3. Repeat following steps till start <= end
       a). Set mid = (start + end)/2.
       b). If mid+1 is pivot, then break.
       c). If array[start] <= array[mid], it means from start to mid, all elements are in sorted order. Set 
       start = mid+1, so that we look for pivot in second half of the array.
       d). Else set end = mid-1, to look for pivot in first half of the array.*/

public class FindElementSortedRotatedArray {

    public static void main(String[] args) {
        int array[] = {156, 235, 457, 21, 32, 43, 74, 75, 86, 97, 108, 149};
        findElementInSortedRotatedArrayTest(array, 108);
        System.out.println("Shifted binary search Index: " + shiftedBinarySearch(array, 0, array.length - 1, 108));
    }

    private static void findElementInSortedRotatedArrayTest(int[] array, int numberToBeSerached) {
        int index = findElementInSortedRotatedArray(array, numberToBeSerached);
        System.out.println("Element: " + numberToBeSerached + (index >= 0 ? (" found at index " + index) : " not found!"));
    }

    // Returning the index of the elements
    public static int findElementInSortedRotatedArray(int[] array, int numberToBeSerached) { 
        if (array == null || array.length == 0 || array.length ==  1) {
            return -1;
        }

        // Index of minimum element
        int pivotIndex = findPivot(array);

        if (pivotIndex >= 0 && numberToBeSerached >= array[0] && numberToBeSerached <= array[pivotIndex - 1]) {
            return binarySearch(array, 0, pivotIndex - 1, numberToBeSerached);
        } else {
            return binarySearch(array, pivotIndex, array.length - 1, numberToBeSerached);
        }
    }

    public static int findPivot(int[] array) {
        // Checking if the array is rotated or not
        if (array.length == 1 || array[0] <= array[array.length - 1]) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {

            int mid = (left + right)/2;
            // check if mid+1 is pivot
            if (array[mid] > array[mid + 1]) {
                return mid + 1;
            } else if (array[left] <= array[mid]) {// Number lies after mid
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] array, int start, int end, int num) {
        if (start > end || start < 0 || end >= array.length) {
            throw new IllegalArgumentException("Invalid values for start and end! start = " + start + ", end = " + end);
        }

        if (num < array[start] || num > array[end]) {
            return -1;
        }

        while (start <= end) {
            int mid = (start + end)/2;
            if (array[mid] == num) {
                return mid;
            } else if (num < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    // Approach without finding pivot. This is known as shifted binary search
    public static int shiftedBinarySearch(int arr[], int low, int high, int key) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        /* If arr[l...mid] first subarray is sorted */
        if (arr[low] <= arr[mid]) {
            /* As this subarray is sorted, we can quickly check if key lies in half or other half */
            if (key >= arr[low] && key < arr[mid]) {
                return shiftedBinarySearch(arr, low, mid - 1, key);
            } else {
                /*If key not lies in first half subarray, Divide other half  into two subarrays,
                such that we can quickly check if key lies in other half */
                return shiftedBinarySearch(arr, mid + 1, high, key);
            }
        }
        /* If arr[l..mid] first subarray is not sorted, 
         * then arr[mid... h] must be sorted subarray */
        if (key > arr[mid] && key <= arr[high]) {
            return shiftedBinarySearch(arr, mid + 1, high, key);
        }

        return shiftedBinarySearch(arr, low, mid - 1, key);
    }
}
