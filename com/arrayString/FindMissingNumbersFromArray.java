package com.arrayString;

// This solution will evenly applicable to both sorted and unsorted array
import java.util.List;
import java.util.ArrayList;

public class FindMissingNumbersFromArray {

    public static void main(String[] args) {
        int[] input = {1, 2, 4, 5, 6, 8, 9};
        List<Integer> missingNumbers = findMissingNumbers(input);
        System.out.println("Missing numbers: " + missingNumbers);
    }

    public static List<Integer> findMissingNumbers(int[] input) {
        int maxNum = 0;

        for (int num: input) {
            if (num > maxNum) {
                maxNum = num;
            }
        }

        /* For sorted array in ascending order 
         * int maxNum = input[input.length - 1];
         */

        // maxNum is helping to defining the range
        // It is initialized with false by default
        boolean[] present = new boolean[maxNum + 1];

        // Making the existing element position true
        for (int num: input) {
            present[num] = true;
        }

        List<Integer> missingNumbers = new ArrayList<>();

        for (int i = 1; i <= maxNum; i++) {
            if (!present[i]) {
                missingNumbers.add(i);
            }
        }

        return missingNumbers;
    }
}
