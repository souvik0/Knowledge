package com.arrayString;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strArr={"java2blog","javaworld","javabean","javatemp"};
        System.out.println(longestCommonPrefix(strArr));
    }

    public static String getMinString(String[] strArr) {
        String minString = strArr[0];

        for (int i = 1; i < strArr.length; i++) {
             if (minString.length() > strArr[i].length()) {
                 minString = strArr[i];
             }
        }

        return minString;
    }

    public static String longestCommonPrefix(String[] strArr) {
        int minPrefixLength = 0;
        // To get the minimum length string from the array
        String minString = getMinString(strArr);

        for (int i = 0 ; i < strArr.length; i++) {
             int j;
             for (j = 0; j < minString.length(); j++) {
                 if (minString.charAt(j) != strArr[i].charAt(j)) {
                     break;
                 }
             }
             if (j < minString.length()) {
                 minPrefixLength = j;
             }
        }

        return minString.substring(0, minPrefixLength);
    }
}