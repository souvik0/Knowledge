package com.arrayString;

import java.util.Arrays;

public class SortVowelsOfString {

    public static void main(String[] args) {
        String str = "Pupusona";
        String sortedVowels = sortVowels(str);
        System.out.println("Original string: " + str);
        System.out.println("String with sorted vowels: " + sortedVowels);
    }

    public static String sortVowels(String str) {
        // Convert the string to lowercase to handle both lowercase and uppercase vowels
        str = str.toLowerCase();
        StringBuilder vowelString = new StringBuilder();

        // Extract all the vowels from the string and store them in vowelString
        for (char ch : str.toCharArray()) {
            if (isVowel(ch)) {
                vowelString.append(ch);
            }
        }

        // Convert vowelString to a character array and sort it
        char[] vowelsFromString = vowelString.toString().toCharArray();
        Arrays.sort(vowelsFromString);

        // Replace the original vowels in the string with the sorted vowels
        int index = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                result.append(vowelsFromString[index++]);
            } else {
                result.append(str.charAt(i));
            }
        }

        return result.toString();
    }

    // Helper method to check if a character is a vowel
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
