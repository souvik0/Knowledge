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

    private static void generatePermutations(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        if (Character.isLetter(chars[index])) {
            // Change the case of the current character and recurse
            chars[index] = Character.toUpperCase(chars[index]);
            generatePermutations(chars, index + 1, result);

            // Change the case of the current character and recurse
            chars[index] = Character.toLowerCase(chars[index]);
            generatePermutations(chars, index + 1, result);
        } else {
            // If the character is not a letter, just recurse without changing it
            generatePermutations(chars, index + 1, result);
        }
    }
}
