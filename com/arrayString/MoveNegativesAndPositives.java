package com.arrayString;

public class MoveNegativesAndPositives {

    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        moveNegativesAndPositives(arr);

        // Print the modified array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void moveNegativesAndPositives(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            if (arr[left] < 0 && arr[right] < 0) {
                // Both numbers are negative, move the left pointer to the right
                left++;
            } else if (arr[left] >= 0 && arr[right] >= 0) {
                // Both numbers are positive, move the right pointer to the left
                right--;
            } else if (arr[left] >= 0 && arr[right] < 0) {
                // Swap positive and negative elements, and move both pointers
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else {
                // No swapping is required
                left++;
                right--;
            }
        }
    }
}
