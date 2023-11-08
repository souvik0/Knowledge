package com.sorting;

import java.util.ArrayList;
import java.util.List;

public class ThreeArraysIntersection {

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 10, 20, 40, 80};
        int[] arr2 = {6, 7, 20, 80, 100};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};

        List<Integer> intersection = findIntersection(arr1, arr2, arr3);
        System.out.println("Intersection: " + intersection);
    }

    public static List<Integer> findIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            // If the current elements of all three arrays are the same, add it to the result
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr2[j]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                // If the current element in the first array is smaller, move to the next element
                i++;
            } else if (arr2[j] < arr3[k]) {
                // If the current element in the second array is smaller, move to the next element
                j++;
            } else {
                // If the current element in the third array is smaller, move to the next element
                k++;
            }
        }

        return result;
    }
}
