package com.arrayString;

public class ReverseStringWithSpecialChar {

    public static void main(String[] args) {
        String str = "!#ab$cd";
        System.out.println(reverseString(str));
    }

    public static String reverseString(String str) {
        char[] strChar = str.toCharArray();
        int left = 0;
        int right = strChar.length - 1;

        while (left < right) {
            while (!Character.isLetter(strChar[left])) {
                left++;
            }
            while (!Character.isLetter(strChar[right])) {
                right--;
            }
            if (left < right) { // Reversal used to take place here
                char temp = strChar[left];
                strChar[left] = strChar[right];
                strChar[left] = temp;
                left++;
                right--;
            }
        }

        // Returning the result in the form of String
        return new String(strChar);
    }
}
