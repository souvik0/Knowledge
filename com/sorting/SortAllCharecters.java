package com.sorting;

/*
 * Given a list of characters, sort it in the non-decreasing order based on ASCII values of 
 * characters.
 * {
 * "arr": ["a", "s", "d", "f", "g", "*", "&", "!", "z", "y"]
 * }
 * Output : ["!", "&", "*", "a", "d", "f", "g", "s", "y", "z"]
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortAllCharecters {

    public static void main(String[] args) {
    }

    static ArrayList<Character> sort_array(ArrayList<Character> arr) {
        Character[] unsortedArray = new Character[arr.size()];
        unsortedArray = arr.toArray(unsortedArray);
        Map<Integer, List<Character>> asciiMap = new TreeMap<Integer, List<Character>>();
        ArrayList<Character> finalList = new ArrayList<Character>();

        for (int i = 0; i < unsortedArray.length; i++) {
             int ascii = (int) unsortedArray[i];
             if (asciiMap.size() != 0 && asciiMap.containsKey(ascii)) {
                 List<Character> charList = asciiMap.get(ascii);
                 charList.add(unsortedArray[i]);
                 asciiMap.put(ascii, charList);
             } else {
                 List<Character> charList = new ArrayList<Character>();
                 charList.add(unsortedArray[i]);
                 asciiMap.put(ascii, charList);
             }
        }
        for (Map.Entry<Integer, List<Character>> entry : asciiMap.entrySet()) {
             finalList.addAll(entry.getValue());
        }
        return new ArrayList<Character>(finalList);
    }
}
