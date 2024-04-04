package com.arrayString;

import java.util.*;

public class FindFirstAndLastNonRepeatingCharacter {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("First non repeating charecter: " + firstNonRepeatingChar(str));
        System.out.println("Last non repeating charecter: " + lastNonRepeatingChar(str));
    }

    public static char firstNonRepeatingChar(String str) {
        char firstNonRepeatingChar = '\0';
        Map<Character, Integer> frequencyMap = new LinkedHashMap<Character, Integer>();

        for (char ch: str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch: frequencyMap.keySet()) {
            int frequency = frequencyMap.get(ch);
            if (frequency == 1) {
                firstNonRepeatingChar = ch;
                break;
            }
        }

        return firstNonRepeatingChar;
    }

    public static char lastNonRepeatingChar(String str) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Integer> frequencyMap = new LinkedHashMap<Character, Integer>();

        for (char ch: str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch: frequencyMap.keySet()) {
            int frequency = frequencyMap.get(ch);
            if (frequency == 1) {
                stack.push(ch);
            }
        }

        if (!stack.isEmpty()) {
            return stack.pop();
        }

        return 0;
    }
}
