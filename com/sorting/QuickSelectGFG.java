package com.sorting;
/* This algorithm is used to find out kth smallest element in the array/ list.
 * On the contrary, it is used to find out (n-k+1)th largest element in the array/list.
 * Best Case : O(n)
 * Average case : O(n)
 * Worst Case : O(n^2)
 * The algorithm is similar to QuickSort.
 * The difference is, instead of recurring for both sides (after finding pivot),
 * it recurs only for the part that contains the k-th smallest/ largest element.
 * The logic is simple, if index of partitioned element is more than k,
 * then we recur for left part. If index is same as k,
 * we have found the k-th smallest element and we return.
 * If index is less than k, then we recur for right part.
 * This reduces the expected complexity from O(nlogn) to O(n), with a worst case of O(n^2).
*/
public class QuickSelectGFG {

    /* Partition function similar to quick sort Considers last element as pivot and adds elements with less value 
     * to the left and high value to the right and also changes the pivot position to its respective final position
     * in the final array.
     */
    public static int partition(int[] arr, int low, int high) {
        // Assumption on pivotIndex & pivotLocation
        int pivotElement = arr[high];
        int pivotLocation = low;

        for (int i = low; i <= high; i++) {
            if (arr[i] < pivotElement) {
                int temp = arr[i];
                arr[i] = arr[pivotLocation];
                arr[pivotLocation] = temp;
                pivotLocation++;
            }
        }

        // Constructing the final array after shuffling of elements
        int temp = arr[high];
        arr[high] = arr[pivotLocation];
        arr[pivotLocation] = temp;

        return pivotLocation;
    }

    /* Finds the kth position (of the sorted array) in a given unsorted array i.e this function
     * can be used to find both kth largest and
     * kth smallest element in the array.
     * ASSUMPTION: all elements in arr[] are distinct
    */
    public static int kthElement(int[] arr, int low, int high, int k) {
        int partitionIndex = partition(arr, low, high);

        if (partitionIndex == k) {
            return arr[partitionIndex];
        } else if (partitionIndex < k) {
            // element present at right side of partitionIndex
            return kthElement(arr, partitionIndex + 1, high, k);
        } else {
            return kthElement(arr, low, partitionIndex - 1, k);
        }
    }

    public static void main(String[] args) {
         int[] array = new int[] {10, 4, 5, 8, 6, 11, 26, 52};

         int kPosition = 7;
         int length = array.length;

         if (kPosition > length) {
             System.out.println("Index out of bound");
         }
         else {
             System.out.println(kPosition + " smallest element in array "+ " or "
                                + (array.length - kPosition + 1) + " largest element in array " +
                                kthElement(array, 0, length - 1, kPosition - 1));
         }
    }
}
