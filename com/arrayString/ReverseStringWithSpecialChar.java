package com.arrayString;

// This should use if. instead of while to perform internal swapping.
public class ReverseStringWithSpecialChar {

    public static void main(String[] args) {
        String str = "!#ab$cd";
        System.out.println(reverseString(str));
    }

    public static String reverseString(String str) {
        char[] pattern = str.toCharArray();
        int left = 0;
        int right = pattern.length - 1;

        while (left < right) {
            if (!Character.isLetter(pattern[left])) {
                left++;
            } else if (!Character.isLetter(pattern[right])) {
                right--;
            } else {
                char temp = pattern[left];
                pattern[left] = pattern[right];
                pattern[right] = temp;
                left++;
                right--;
            }
        }

        // Returning the result in the form of String
        return new String(pattern);
    }
}
