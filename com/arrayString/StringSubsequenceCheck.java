package com.arrayString;

public class StringSubsequenceCheck {

    public static void main(String[] args) {
        String str1 = "Souvik";
        String str2 = "geeksforgeeks";
        int smallerStringlength = str1.length();
        int largerStringlength = str2.length();
        System.out.println(isSubSequence(str1, str2, smallerStringlength, largerStringlength));
    }

    // Returns true if str1[] is a subsequence of str2[]
    // m is length of str1 and n is length of str2
    public static boolean isSubSequence(String str1, String str2, int smallerStringlength, int largerStringlength) {
        // Base Cases
        if (smallerStringlength == 0)
            return true;
        if (largerStringlength == 0)
            return false;
        // If last characters of two strings are matching
        if (str1.charAt(smallerStringlength - 1) == str2.charAt(largerStringlength - 1)) {
            return isSubSequence(str1, str2, smallerStringlength - 1, largerStringlength - 1);
        }
        // If last characters are not matching
        return isSubSequence(str1, str2, smallerStringlength, largerStringlength - 1);
    }
}
