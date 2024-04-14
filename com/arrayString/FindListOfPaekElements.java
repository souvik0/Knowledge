package com.arrayString;

import java.util.*;

public class FindListOfPaekElements {

    public static void main(String[] args) {
        int nums[] = {1, 4, 3, 6, 7, 5};
        List<Integer> peakElements = findPeakElements(nums);
        System.out.println("Peak Elements: " + peakElements);
    }

    public static List<Integer> findPeakElements(int[] arr) {
        List<Integer> peaks = new ArrayList<>();

        if (arr == null || arr.length == 0) {
            return peaks;
        }

        int n = arr.length;
        if (n == 1) {
            peaks.add(arr[0]);
            return peaks;
        }

        if (arr[0] > arr[1]) {
            peaks.add(arr[0]);
        }

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                peaks.add(arr[i]);
            }
        }

        if (arr[n - 1] > arr[n - 2]) {
            peaks.add(arr[n - 1]);
        }

        return peaks;
    }
}
