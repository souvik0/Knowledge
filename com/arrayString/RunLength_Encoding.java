package com.arrayString;

public class RunLength_Encoding {

    public static void main(String[] args) {
        String str = "wwwwaaadexxxxxxyww";
        System.out.println(printRLE(str));
    }

    public static String printRLE(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int counter = 1;

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                counter++;
            } else {
                result.append(input.charAt(i));
                result.append(counter);

                // get back to initial value of count
                counter = 1;
            }
        }

        // Append the last character and its count
        result.append(input.charAt(input.length() - 1));
        result.append(counter);

        return result.toString();
    }
}
