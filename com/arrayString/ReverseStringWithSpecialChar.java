package com.arrayString;

public class ReverseStringWithSpecialChar {

    public static void main(String[] args) {
        String str = "!#ab$cd";
        System.out.println(reverseString(str));
    }

    public static String reverseString(String str) {
        char[] strChar = str.toCharArray();
        int i = 0;
        int j = strChar.length - 1;

        while (i < j) {
            while (!Character.isLetter(strChar[i])) {
                i++;
            }
            while (!Character.isLetter(strChar[j])) {
                j--;
            }
            if (i < j) { // Reversal used to take place here
                char temp = strChar[i];
                strChar[i] = strChar[j];
                strChar[j] = temp;
                i++;
                j--;
            }
        }

        // Returning the result in the form of String
        return new String(strChar);
    }
}
