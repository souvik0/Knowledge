package com.sorting;

/* 1. Create Max Heap (General procedure O(nlogn)) from the given array using heapify algorithm.
 * Time complexity O(n).
   2. Delete element one by one & put into the last index of the array
      a. delete from root
      b. put deleted element at free space in array(ideally last position onwards)
      c. reduce the heap size
      d. adjust to maintain max Heap property even after elements gets deleted
*/
import java.util.Arrays;

public class HeapSortImplementation {

    public static void main(String[] args) {
        int[] arr= {1,10,16,19,3,5};
        System.out.println("Before Heap Sort: ");
        System.out.println(Arrays.toString(arr));
        arr = heapSort(arr);
        System.out.println("=====================");
        System.out.println("After Heap Sort : ");
        System.out.println(Arrays.toString(arr));
    }

    public static int[] heapSort(int[] array) {
        // Build heap from Array using heapify mechanism
        buildHeap(array);
        int sizeOfHeap = array.length -1;
        /* start deleting elements from heap one by one & maintain heap property
           Delete element one by one 
           a. delete from root
           b. adjust to maintain max Heap property even after elements gets deleted
           c. put deleted element in free space at array
        */
        for (int i = sizeOfHeap; i >= 0; i--) {
            /* Root of heap is the start element of the array. Swap root & last element of the array.
               To place root element at the last position of the array
            */
            exchange(array, 0, i);
            /* delete last element (Which is nothing but root) from heap & get reduced heap size
               Keep the root element in array (at last position), but not part of heap
            */
            sizeOfHeap = sizeOfHeap -1;
            /* Due to this shifting of elements max heap property gets disturbed.
               So, balance it once again with heapify mechanism
               Root element always gets deleted & exchanged with ith element,
               so, heapify keeping 0th element constant
            */
            heapify(array, 0, sizeOfHeap);
        }
        return array;
    }

    public static void buildHeap(int[] array) {
        // Size of heap is equal to length of array to be sorted
        int sizeOfHeap = array.length - 1;

        /*  While building heap using heapify, always starts from the last index of array.
            individual leaf nodes (index of array) are heap by default.
            last non-leaf node will be at (array.length -1)/2
            Omitting all leaf nodes, which drastically reduces time complexity.
        */
        for (int i = (sizeOfHeap/2); i >= 0; i--) {
            heapify(array, i, sizeOfHeap);
        }
    }

    public static void heapify(int[] array, int i, int sizeOfHeap) {
        // left child index
        int leftIndex = 2*i + 1;

        // right child index
        int rightIndex = 2*i + 2;

        // index of largest element (Considering ith element as the largest one)
        int largestIndex = i;

        if (leftIndex <= sizeOfHeap && array[leftIndex] > array[largestIndex]) {
            largestIndex = leftIndex;
        }
        if (rightIndex <= sizeOfHeap && array[rightIndex] > array[largestIndex]) {
            largestIndex = rightIndex;
        }
        /* If largest is not current node, exchange it with max of left and right child to maintain heap property
           If current node isn't largest adjust the position in array 
        */
        if (largestIndex != i) {
            // Exchange between ith element & largest element
            exchange(array, i, largestIndex);
            // Due to this swapping max heap property gets disturbed, so heapify once again
            heapify(array, largestIndex, sizeOfHeap);
        }
    }

    public static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
