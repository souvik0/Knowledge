package com.recursion;
// Time Complexity: O(2n*n)

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args) {
        String input = "a1b2";
        List<String> permutations = letterCasePermutation(input);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        generatePermutations(S.toCharArray(), 0, result);
        return result;
    }

    private static void generatePermutations(char[] pattern, int start, List<String> result) {
        if (start == pattern.length) {
            result.add(new String(pattern));
            return;
        }

        if (Character.isLetter(pattern[start])) {
            // Change the case of the current character and recurse
            pattern[start] = Character.toUpperCase(pattern[start]);
            generatePermutations(pattern, start + 1, result);

            // Change the case of the current character and recurse
            pattern[start] = Character.toLowerCase(pattern[start]);
            generatePermutations(pattern, start + 1, result);
        } else {
            // If the character is not a letter, just recurse without changing it
            generatePermutations(pattern, start + 1, result);
        }
    }
}
