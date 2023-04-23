package com.arrayString;

public class ReverseStringWithSpecialChar {

    public static void main(String[] args) {
        String str = "!abcd";
        System.out.println(reverseString(str));
    }

    public static String reverseString(String str) {
        char[] strChar = str.toCharArray();
        int i = 0;
        int j = strChar.length - 1;

        while (i < j) {
            if (!Character.isLetter(strChar[i])) {
                i++;
            } else if (!Character.isLetter(strChar[j])) {
                j--;
            } else {
                char temp = strChar[i];
                strChar[i] = strChar[j];
                strChar[j] = temp;
                i++;
                j--;
            }
        }

        return new String(strChar);
    }
}
