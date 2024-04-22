package com.arrayString;

import java.util.*;

public class RunLengthEncodingComplex {

    public static void main(String[] args) {
        String input = "aaabbcccckjjlozzaaazz";
        runLengthEncoding(input);
    }

    public static void runLengthEncoding(String input) {
        Map<String,Integer> map = new LinkedHashMap<>();
        int count = 1;

        for (int i = 0; i < input.length(); i++){
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)){
                count++;
            } else {
                // adding space to convert to string
                String str = input.charAt(i) + "" ;
                String repeatedStr = str.repeat(count);
                map.merge(repeatedStr, 1, (a, b) -> a + b);
                // Backtrack count for another character
                count = 1;
            }
        }

        map.forEach((key,value) -> System.out.println(key + " -- " + value));
    }
}
