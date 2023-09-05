package com.arrayString;
// Time Complexity: O(n)
import java.util.Arrays;

public class RightRotateArray {

    public static void main(String[] args){
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rightRotate(A, k);
        System.out.println(Arrays.toString(A));
    }

    // Function to right-rotate an array by `k` positions
    public static void rightRotate(int[] A, int k) {
        int n = A.length;

        // base case: invalid input
        if (k < 0 || k >= n) {
            return;
        }

        // construct an auxiliary array of size `k` and
        // fill it with the last `k` elements of the input array
        int[] aux = new int[k];
        for (int i = 0; i < k; i++) {
            aux[i] = A[n - k + i];
        }

        // shift the first `n-k` elements of the input array at the end
        for (int i = n - k - 1; i >= 0; i--) {
            A[i + k] = A[i];
        }

        // put the elements of the auxiliary array at their
        // correct positions in the input array
        for (int i = 0; i < k; i++) {
            A[i] = aux[i];
        }
    }
}
