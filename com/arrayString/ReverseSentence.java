package com.arrayString;

import java.util.regex.Pattern;

public class ReverseSentence {

	public static void main(String[] args) {
       // TODO Auto-generated method stub
       String s1 = "Welcome    to   geeksforgeeks";
       System.out.println(reverseSentence(s1));
       System.out.println("Recusrion approach: " +reverseWithRecursion(s1));

       String s2 = "I   love    Java Programming";
       String s3 = "Souviuk";
       System.out.println(reverseSentence(s2));
       System.out.println(reverse(s3));
    }

    public static String reverseSentence(String str) {
        Pattern pattern = Pattern.compile("\\s");
        String[] strArr = pattern.split(str);
        String result = "";

        for (int i = 0; i < strArr.length; i++) {
            if (i == strArr.length - 1) {
                result = strArr[i] + result;
            } else {
                result = " " + strArr[i] + result;
            }
        }

        return result;
    }

    // Substring function exclude latsIndex. This property has been used here with space.
    public static String reverseWithRecursion(String str) {
        if ((str == null) || (str.length() <= 1)) {
            return "";
        } else {
            return reverseWithRecursion(str.substring(0, str.length() - 1)) +
                   str.charAt(str.length() -1);
        }
    }

    // This applies for reversal of words
    public static String reverse(String word) {
        if ((word == null) || (word.length() <= 1)) {
            return word;
        } else {
            return reverse(word.substring(1)) + 
                   word.charAt(0);
        }
    }
}