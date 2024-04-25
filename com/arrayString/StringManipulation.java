package com.arrayString;

public class StringManipulation {

    public static void main(String[] args) {
        String input = "[aa]2[b]1[cc]2";
        System.out.println(manipulateString(input));
    }

    public static String manipulateString(String input) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < input.length()) {
            char currentChar = input.charAt(i);

            // Check if the current character is '['
            if (currentChar == '[') {
                int j = i + 1;

                // Find the closing ']'
                while (j < input.length() && input.charAt(j) != ']') {
                    j++;
                }

                // Extract the characters inside the brackets
                String content = input.substring(i + 1, j);

                // Find the number after the ']'
                int k = j + 1;
                while (k < input.length() && Character.isDigit(input.charAt(k))) {
                    k++;
                }

                // Extract the number
                int repeat = Integer.parseInt(input.substring(j + 1, k));

                // Append the characters inside the brackets to the result string
                for (int l = 0; l < repeat; l++) {
                    result.append(content);
                }

                // Move the index to the character after the number
                i = k;
            } else {
                // Append the character if it's not inside brackets
                result.append(currentChar);
                i++;
            }
        }

        return result.toString();
    }
}
