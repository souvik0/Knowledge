package com.arrayString;

public class StartingIndexOfSmallerStringInsideLargerString {

    public static void main(String[] args) {
        String smallerString = "abc";
        String largerString = "xyzabcdef";
        int index = indexOfSmallerString(smallerString, largerString);
        System.out.println("Index of first occurrence: " + index);
    }

    public static int indexOfSmallerString(String smallerString, String largerString) {
        if (smallerString == null || largerString == null || smallerString.length() == 0 || largerString.length() == 0) {
            return -1;
        }

        for (int i = 0; i <= largerString.length() - smallerString.length(); i++) {
            boolean found = true;
            for (int j = 0; j < smallerString.length(); j++) {
                if (largerString.charAt(i + j) != smallerString.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;  // Return the index of the first occurrence
            }
        }

        return -1;  // A is not present in B
    }
}
