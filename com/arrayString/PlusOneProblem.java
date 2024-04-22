package com.arrayString;

public class PlusOneProblem {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9, 9};
        int[] result = plusOne(digits);
        printArray(result);
    }

    public static int[] plusOne(int[] digits) {
        // Start adding from the rightmost digit
        for (int i = digits.length - 1; i >= 0; i--) {
            // If the current digit is less than 9, simply increment it and return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If the current digit is 9, set it to 0 and continue to the next digit
            digits[i] = 0;
        }
        // If we reach here, it means all digits were 9
        // In this case, we need to add a new digit 1 at the beginning of the array
        int[] result = new int[digits.length + 1];
        result[0] = 1; // Carry 1 will come at first.

        return result;
    }

    // Utility method to print an array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
