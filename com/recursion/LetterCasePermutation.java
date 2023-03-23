package com.recursion;
// Time Complexity: O(2n*n)

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args) {
        List<String> resultList = letterCasePermutation("A1C");
        System.out.println(resultList.toString());
    }

    public static List<String> letterCasePermutation(String str) {
        int letterCount = 0;
        for (char letter: str.toCharArray()) {
            if (Character.isLetter(letter)) {
                letterCount++;
            }
        }

        List<String> resultList = new ArrayList<String>();

        for (int bits = 0; bits < 1 << letterCount; bits++) {
            int b = 0;
            StringBuilder word = new StringBuilder();

            for (char letter: str.toCharArray()) {
                if (Character.isLetter(letter)) {
                    // Checking the conversion logic
                    if (((bits >> b++) & 1) == 1) {
                        word.append(Character.toLowerCase(letter));
                    } else {
                        word.append(Character.toUpperCase(letter));
                    }
                } else {
                    word.append(letter);
                }
            }

            resultList.add(word.toString());
        }

        return resultList;
    }
}
