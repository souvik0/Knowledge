package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberPadString {

    public static Character[][] numberToCharMap;

    public static void main(String[] args) {
        int number[] = {9, 2, 7};
        printWords(number);
    }

    private static void printWords(int[] numbers) {
        generateNumberToCharMap();
        List<String> stringList = printWords(numbers, numbers.length, 0, "");
        stringList.stream().forEach(System.out::println);
    }

    private static void generateNumberToCharMap() {
        numberToCharMap = new Character[10][4];
        numberToCharMap[0] = new Character[] {'\0'};
        numberToCharMap[1] = new Character[] {'\0'};
        numberToCharMap[2] = new Character[] {'a', 'b', 'c'};
        numberToCharMap[3] = new Character[] {'d', 'e', 'f'};
        numberToCharMap[4] = new Character[] {'g', 'h', 'i'};
        numberToCharMap[5] = new Character[] {'j', 'k', 'l'};
        numberToCharMap[6] = new Character[] {'m', 'n', 'o'};
        numberToCharMap[7] = new Character[] {'p', 'q', 'r', 's'};
        numberToCharMap[8] = new Character[] {'t', 'u', 'v'};
        numberToCharMap[9] = new Character[] {'w', 'x', 'y', 'z'};
    }

    private static List<String> printWords(int[] numbers, int len, int start, String s) {
        // Validation condition
        if (len == start) {
            return new ArrayList<>(Collections.singleton(s));
        }

        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < numberToCharMap[numbers[start]].length; i++) {
            String sCopy = String.copyValueOf(s.toCharArray());
            sCopy = sCopy.concat(numberToCharMap[numbers[start]][i].toString());
            resultList.addAll(printWords(numbers, len, start + 1, sCopy));
        }

        return resultList;
    }
}
