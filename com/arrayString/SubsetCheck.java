package com.arrayString;

import java.util.*;

public class SubsetCheck {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 1, 4};

        boolean isSubset = isSubset(arr1, arr2);

        if (isSubset) {
            System.out.println("arr2 is a subset of arr1");
        } else {
            System.out.println("arr2 is not a subset of arr1");
        }
    }

    public static boolean isSubset(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        // Add all elements of arr1 to the HashSet
        for (int num : arr1) {
            set.add(num);
        }

        // Check if all elements of arr2 are present in the HashSet
        for (int num : arr2) {
            if (!set.contains(num)) {
                return false;
            }
        }

        return true;
    }
}
