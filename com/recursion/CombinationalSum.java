package com.recursion;

/*
 * Time Complexity: O(nlogn) for sorting, O(2^n) for generating a number of combinations.
 * If ‘k’ is the avg length of every combination then adding it to the resultant list would 
 * take O(k x 2^n). Total complexity is O(nlogn) + O(k x 2^n).
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class CombinationalSum {

    // Driver code
    public static void main(String[] args) {
        Integer[] arr = {10, 1, 2, 7, 6, 1, 5};
        Vector<Integer> A = new Vector<>(Arrays.asList(arr));
        int targetSum = 8;
        // Function call
        combination(A, targetSum);
    }

    public static void combination(Vector<Integer> A, int targetSum) {
        // Sort the given elements
        Collections.sort(A);
        // To store combination
        Vector<Integer> local = new Vector<Integer>();
        unique_combination(0, 0, targetSum, local, A);
    }

    // Function to find all unique combination of
    // given elements such that their sum is K
    public static void unique_combination(int start, int currentSum, int targetSum,
                                          Vector<Integer> local, Vector<Integer> A) {
        // If a unique combination is found
        if (currentSum == targetSum) {
            System.out.print("{");

            for (int i = 0; i < local.size(); i++) {
                System.out.print(local.get(i));
                if (i != local.size() - 1) {
                    System.out.print(",");
                }
            }

            System.out.println("}");
            return;
        }

        // For all other combinations
        for (int i = start; i < A.size(); i++) {
            // Check if the sum exceeds K
            if (currentSum + A.get(i) > targetSum) {
                continue;
            }

            // Check if it is repeated or not
            if (i > start && A.get(i) == A.get(i - 1)) {
                continue;
            }

            // Take the element into the combination
            local.add(A.get(i));

            // Recursive call
            unique_combination(i + 1, currentSum + A.get(i), targetSum, local, A);

            // Remove element from the combination for backtracking
            local.remove(local.size() - 1);
        }
    }
}
