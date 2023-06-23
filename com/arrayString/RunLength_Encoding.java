package com.arrayString;

public class RunLength_Encoding {

    public static void main(String[] args) {
        String str = "wwwwaaadexxxxxxywww";
        printRLE(str);
    }

    public static void printRLE(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            int counter = 1;

            // index of for loop needs to be increased to avoid recurrence
            // Also needs to check reach of i
            while (i < length -1 && str.charAt(i) == str.charAt(i + 1)) {
                counter++;
                i++;
            }

            // Print character and its count
            System.out.println(str.charAt(i) + ":" + counter);
        }
    }
}
