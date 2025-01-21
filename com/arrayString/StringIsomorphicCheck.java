package com.arrayString;

// Time Complexity: O(N)
// Space Complexity: O(1)

import java.util.*;

public class StringIsomorphicCheck {

    public static void main(String[] args){
        String str1 = "foo";
        String str2 = "bar";

        // Function Call
        if (str1.length() == str2.length() && areIsomorphic(str1, str2)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static boolean areIsomorphic(String str1, String str2) {
        HashMap<Character, Character> charMap = new HashMap<Character, Character>();

        for (int i = 0; i < str1.length(); i++) {
            if (charMap.containsKey(str1.charAt(i))) {
                char charOfStr2 = charMap.get(str1.charAt(i));
                if (charOfStr2 != str2.charAt(i)) {
                    return false;
                }
            } else if (!charMap.containsValue(str2.charAt(i))) {
                charMap.put(str1.charAt(i), str2.charAt(i));
            } else {
                return false;
            }
        }

        return true;
    }
}
