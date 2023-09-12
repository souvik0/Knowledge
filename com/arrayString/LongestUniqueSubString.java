package com.arrayString;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubString {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println("The input String is " + s);
        String result = findLongestUniqueSubstring(s);
        System.out.println("The longest unique substring is: " + result);
    }

    public static String findLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLength = 0; // Maximum length of unique substring found so far
        int start = 0; // Starting index of the current unique substring
        int maxStart = 0; // Starting index of the longest unique substring found so far

        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is already in the substring, update the starting index
            if (charIndexMap.containsKey(ch) && charIndexMap.get(ch) >= start) {
                start = charIndexMap.get(ch) + 1;
            }

            // Update the character's index in the map
            charIndexMap.put(ch, i);

            // Calculate the current substring length
            int currentLength = i - start + 1;

            // If the current substring is longer than the maximum found so far, update the maximum
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = start;
            }
        }

        // Extract and return the longest unique substring
        return s.substring(maxStart, maxStart + maxLength);
    }
}
