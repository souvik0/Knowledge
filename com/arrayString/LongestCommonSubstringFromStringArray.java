package com.arrayString;

public class LongestCommonSubstringFromStringArray {

    public static void main(String[] args) {
        String arr[] = {"graceful", "grace", "disgraceful","gracefully"};

        // Function call
        String stems = findLongestCommonSubString(arr);
        System.out.println(stems);
    }

    public static String findLongestCommonSubString(String arr[]) {
        // Determine size of the array
        int n = arr.length;

        // Take first string from array as reference
        String s = arr[0];
        int len = s.length();

        String result = "";

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {

                // generating all possible substrings
                // of our reference string arr[0] i.e s
                String subString = s.substring(i, j);
                int k;
                for (k = 1; k < n; k++) {
                    // Check if the generated stem is
                    // common to all words
                    if (!arr[k].contains(subString))
                        break;
                }

                // If current substring is present in
                // all strings and its length is greater
                // than current result
                if (k == n && result.length() < subString.length())
                    result = subString;
            }
        }

        return result;
    }
}
