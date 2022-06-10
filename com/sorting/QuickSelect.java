package com.sorting;

public class QuickSelect {

    public static void main(String[] args) {
        int[] array = new int[] {10, 4, 5, 8, 6, 11, 26};
        System.out.println("Kth smallest element: " + quickSelect(array, 0, array.length - 1, 5));
    }

    public static int partition(int[] array, int left, int right) {
       int pivot = array[left];
       int leftMark = left + 1;
       int rightMark = right;

       while (true) {
           while (leftMark < right && array[leftMark] < pivot) {
               leftMark++;
           }
           while (rightMark > left && array[rightMark] > pivot) {
               rightMark--;
           }
           if (leftMark >= rightMark) {
               break;
           } else {
              exchange(array, leftMark, rightMark);
           }
       }

       int temp = array[left];
       array[left] = array[leftMark];
       array[leftMark] = temp;

       return rightMark;
    }

    public static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int quickSelect(int array[], int left, int right, int k) {
        if (left == right) {
            return array[left];
        }
        int partition = partition(array, left, right);
        int length = partition - left + 1;
        if (k == length) {
            return array[partition];
        } else if (k < length) {
            return quickSelect(array, left, partition-1, k);
        } else {
            return quickSelect(array, partition+1, right, k);
        }
    }
}
