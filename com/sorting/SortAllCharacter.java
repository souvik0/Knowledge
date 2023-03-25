package com.sorting;

import java.util.Arrays;

public class SortAllCharacter {

    public static void main(String[] args) {
        String s = "Pupusona";
        sortString(s);
    }

    public static void sortString(String s) {
        char[] stringToChar = s.toCharArray();
        Arrays.sort(stringToChar);
        System.out.println(String.valueOf(stringToChar));
    }
}
