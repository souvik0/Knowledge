package com.sorting;

import java.util.Arrays;

public class SortLargeNumberArray {

    public static void main(String[] args) {
        String arr[] = {"5", "1237637463746732323", "97987", "12"};
        sortLargeNumbers(arr);
        for (String s : arr) {
            System.out.print(s + " ");
        }
    }

    public static void sortLargeNumbers(String[] arr) {
        Arrays.sort(arr, (left, right) -> {
            if (left.length() != right.length()) {
                return left.length() - right.length();
            }
            return left.compareTo(right);
        });
    }
}
