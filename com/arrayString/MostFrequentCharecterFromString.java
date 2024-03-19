package com.arrayString;

import java.util.*;

public class MostFrequentCharecterFromString {

    public static void main(String[] args) {
        String input = "hello world";
        char mostFrequent = mostFrequentCharacter(input);
        System.out.println("Most frequent character: " + mostFrequent);
    }

    public static char mostFrequentCharacter(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        // Create a HashMap to store character frequencies
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        // Iterate through the string and count the frequency of each character
        for (char ch : str.toCharArray()) {
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Find the character with the maximum frequency
        char mostFrequentChar = str.charAt(0); // Initialize with the first character
        int maxFrequency = charFrequencyMap.get(mostFrequentChar);

        for (char ch : charFrequencyMap.keySet()) {
            int frequency = charFrequencyMap.get(ch);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequentChar = ch;
            }
        }

        return mostFrequentChar;
    }
}
