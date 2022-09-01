package com.arrayString;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubString {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println("The input String is " + s);
        String result = longestUniqueSubsttr(s);
        System.out.println("The longest unique substring is: " + result);
    }

    public static String longestUniqueSubsttr(String str) {
        // Keeps each character from String & count of every character
        Map<Character, Integer> lastSeen = new HashMap<Character, Integer>();
        int[] longest = new int[] {0, 1};
        int startIdx = 0; // Denotes start index of every substring

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (lastSeen.containsKey(ch)) {
                // Formation of startIdx of every substring
                startIdx = Math.max(startIdx, lastSeen.get(ch) + 1);
            }
            // Checking the length of the substring
            if (longest[1] - longest[0] < (i + 1 - startIdx)) {
                longest = new int[] {startIdx, i + 1};
            }
            lastSeen.put(ch, i);
        }

        String result = str.substring(longest[0], longest[1]);

        return result;
    }
}
