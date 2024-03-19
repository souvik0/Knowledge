package com.arrayString;

public class ReverseSentence {

    public static void main(String[] args) {
       // TODO Auto-generated method stub
       String s1 = "I   love    Java Programming";
       System.out.println(reverseSentence(s1));

       String s2 = "Souviuk";
       System.out.println(reverse(s2));
    }

    public static String reverseSentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence; // Return empty string or null if input is empty or null
        }

        // Split the sentence into words using space as delimiter
        String[] words = sentence.split("\\s+");

        // Create a StringBuilder to build the reversed sentence
        StringBuilder sb = new StringBuilder();

        // Iterate through the words in reverse order and append them to the StringBuilder
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" "); // Append space between words, except for the last word
            }
        }

        return sb.toString();
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
