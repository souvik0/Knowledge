package com.arrayString;
// Product without self
public class ArrayOfProductWithoutSelf {

    public static void main(String[] args) {
        int arr[] = {10, 3, 5, 6, 2};
        int n = arr.length;
        System.out.println("The product array is: ");
        productArray(arr, n);
    }

    public static void productArray(int[] arr, int n) {
        int[] left = new int[n];
        int[] right = new int[n];
        int[] product = new int[n];

        left[0] = 1;
        right[n-1] = 1;

        // Populate left array by multiplying individual elements of left of the main array
        for (int i = 1; i < n ; i++) {
            left[i] = arr[i-1] * left[i-1];
        }

        // Populate right array by multiplying individual elements of right of the main array
        for (int j = n - 2; j >= 0; j--) {
            right[j] = arr[j+1] * right[j+1];
        }

        for (int k = 0; k < n; k++) {
            product[k] = left[k] * right[k];
            System.out.println(product[k] + " ");
        }
    }
}
