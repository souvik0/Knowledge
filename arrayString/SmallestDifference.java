package com.arrayString;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {
        // Input given array A
        int A[] = {1, 2, 11, 5};
        // Input given array B
        int B[] = {4, 12, 19, 23, 127, 235};
        System.out.println("Minimum diffrernce between two arrays: " + 
                            findSmallestDifference(A, B, A.length, B.length));
    }

    public static int findSmallestDifference(int[] A, int[] B, int m, int n) {
        int i = 0;
        int j = 0;
        int minDiff = Integer.MAX_VALUE;

        Arrays.sort(A);
        Arrays.sort(B);

        while (i < m && j < n) {
            if (Math.abs(A[i] - B[j]) < minDiff) {
                minDiff = Math.abs(A[i] - B[j]);
            }
            if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }

        return minDiff;
    }
}
