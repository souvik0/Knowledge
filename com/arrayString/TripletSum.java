package com.arrayString;

// Finding out triplet sum equals to zero
import java.util.Arrays;

public class TripletSum {

    public static void main(String[] args) {
        int A[] = {0, -1, 2, -3, 1};
        int arr_size = A.length;
        find3Numbers(A, arr_size, 0);
    }

    public static void find3Numbers(int[] arr, int n, int givenSum) {
        // sort array elements
        Arrays.sort(arr);
        for (int i = 0; i < n-1; i++) {
            // consider x representing ith element of the array
            int x = arr[i];
            // initialize left (next to ith index) and right (last index) index
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = x + arr[left] + arr[right];
                if (currentSum == givenSum) {
                    // print elements if it's sum is zero
                    System.out.print("Triplet sum: ");
                    System.out.print(x + " ");
                    System.out.print(arr[left]+ " ");
                    System.out.println(arr[right]+ " ");
                    left++;
                    right--;
                }
                // If sum of three elements is less
                // than zero then increment in left
                else if (currentSum < givenSum) {
                    left++;
                }
                // if sum is greater than zero than
                // decrement in right side
                else {
                    right--;
                }
            }
        }
    }
}
