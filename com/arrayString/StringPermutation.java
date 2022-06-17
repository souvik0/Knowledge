package com.arrayString;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

    public static void main(String[] args) {
        Set<String> permutations = new HashSet<String>();
        String str = "pupu";
        System.out.println(permute(str, 0, str.length(), permutations).toString());
    }

    public static Set<String> permute(String str, int left, int right, Set<String> permutations) {
        // This is recursion terminating condition
        if (left == right - 1) {
        	permutations.add(str);
        }

        for (int i = left; i < right; i++) {
            str = swapString(str, left, i);
            permute(str, left + 1, right, permutations);
            // Backtracking of string to calculate the next sequence
            str = swapString(str, left, i);
        }

        return permutations;
    }

    public static String swapString(String str, int i, int j) {
        char[] b = str.toCharArray();
        char temp = b[i];
        b[i] = b[j];
        b[j] = temp;
        return String.valueOf(b);
    }
}
