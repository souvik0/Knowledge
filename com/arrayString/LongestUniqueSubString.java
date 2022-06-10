package com.arrayString;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubString {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println("The input String is " + s);
        int length = longestUniqueSubsttr(s);
        System.out.println("The length of the longest non-repeating character substring is " + length);
    }

    public static int longestUniqueSubsttr(String str) {
        Map<Character, Integer> seen = new HashMap<Character, Integer>();
        int maximum_length = 0;
        int start = 0;

        for (int i = 0; i < str.length(); i++) {
            if (seen.containsKey(i)) {
                // Forwarding start pointer further
                start = Math.max(start, seen.get(str.charAt(i)) + 1);
            }
            seen.put(str.charAt(i), i);
            maximum_length = Math.max(maximum_length, (i - start +1));
        }
        return maximum_length;
    }
}
