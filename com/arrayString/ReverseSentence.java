package com.arrayString;

import java.util.regex.Pattern;

public class ReverseSentence {

	public static void main(String[] args) {
       // TODO Auto-generated method stub
       String s1 = "I   love    Java Programming";
       System.out.println(reverseSentence(s1));

       String s2 = "Souviuk";
       System.out.println(reverse(s2));
    }

    public static String reverseSentence(String str) {
        Pattern pattern = Pattern.compile("\\s");
        String[] strArr = pattern.split(str);
        String result = "";

        if (str == " ") {
           result = " ";
        }

        for (int i = 0; i < strArr.length; i++) {
            if (i == strArr.length - 1) {
                result = strArr[i] + result;
            } else {
                result = " " + strArr[i] + result;
            }
        }

        return result;
    }

    // This applies for reversal of words
    // Start reversing from first index character
    public static String reverse(String word) {
        if ((word == null) || (word.length() <= 1)) {
            return word;
        } else {
            return reverse(word.substring(1)) + 
                   word.charAt(0);
        }
    }
}