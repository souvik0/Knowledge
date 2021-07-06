package com.arrayString;

public class StringSubsequenceCheck {

    public static void main(String[] args) {
        String str1 = "geeks";
        String str2 = "geeksforgeeks";
        int smallerString = str1.length();
        int largerString = str2.length();
        System.out.println(isSubSequence(str1, str2, smallerString, largerString));
    }
    // Returns true if str1[] is a subsequence of str2[]
    // m is length of str1 and n is length of str2
    public static boolean isSubSequence(String str1, String str2, int m, int n) {
        // Base Cases
        if (m == 0)
            return true;
        if (n == 0)
            return false;
        // If last characters of two strings are matching
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return isSubSequence(str1, str2, m - 1, n - 1);
        }
        // If last characters are not matching
        return isSubSequence(str1, str2, m, n - 1);
    }
}
