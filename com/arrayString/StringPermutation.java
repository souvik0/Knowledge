package com.arrayString;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

    public static void main(String[] args) {
        String str = "pupusona";
        System.out.println(getPermutation(str).toString());
    }

    public static Set<String> getPermutation(String str) {
         // create a set to avoid duplicate permutation
        Set<String> permutations = new HashSet<String>();

        // check if string is null
        if (str == null) {
            return null;
        } else if (str.length() == 0 || str.isEmpty()) {
            // terminating condition for recursion
            permutations.add("");
            return permutations;
        } else if (str.length() == 1) {
            permutations.add(str);
            return permutations;
        }

        // get the first character
        char first = str.charAt(0);

        // get the remaining substring
        String sub = str.substring(1);

        // make recursive call to getPermutation()
        Set<String> words = getPermutation(sub);

        // Access each element from words
        for (String strNew : words) {
            for (int i = 0; i <= strNew.length(); i++){
                // insert the permutation to the set
                permutations.add(strNew.substring(0, i) + first + strNew.substring(i));
            }
        }

        return permutations;
    }
}
