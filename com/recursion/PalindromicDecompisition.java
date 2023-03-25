package com.recursion;

//Time Complexity : O(n*2^n)
import java.util.ArrayList;

public class PalindromicDecompisition {

    public static void main(String[] args) {
        String s = "geeks";
        ArrayList<ArrayList<String>> partitions = new ArrayList<>();
        partition(s, partitions);
    }

    // Generates all palindromic partitions of 's' and
    // stores the result in 'v'.
    public static void partition(String s, ArrayList<ArrayList<String>> finalList) {
        // temporary ArrayList to store each palindromic string
        ArrayList<String> temp = new ArrayList<>();

        // calling addString method it adds all 
        // the palindromic partitions to v
        finalList = addStrings(finalList, s, temp, 0);

        // printing the solution
        printSolution(finalList);
    }

    // Goes through all indexes and recursively add remaining
    // partitions if current string is palindrome.
    public static ArrayList<ArrayList<String>> addStrings(ArrayList<ArrayList<String>> finalList,
           String s, ArrayList<String> temp, int start) {

        int len = s.length();
        String str = "";
        ArrayList<String> current = new ArrayList<>(temp);

        // Iterate over the string
        for (int i = start; i < len; ++i) {
            // Partitioning individual characters from String
            str = str + s.charAt(i);

            // check whether the substring is palindromic or not
            if (checkPalindrome(str)) {
                // if palindrome add it to temp list
                temp.add(str);

                if (i + 1 < len) {
                    // recurr to get all the palindromic partitions for the substrings
                	finalList = addStrings(finalList, s, temp, i + 1);
                }
                else {
                    // if end of the string is reached add temp to v
                    finalList.add(temp);
                }

                // temp is reinitialize with the current i as backtracking
                temp = new ArrayList<>(current);
            }
        }

        return finalList;
    }

    // Returns true if str is palindrome, else false
    public static boolean checkPalindrome(String str) {
        int len = str.length();
        len--;

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != str.charAt(len)) {
                return false;
            }
            len--;
        }

        return true;
    }

    // Prints the partition list
    public static void printSolution(ArrayList<ArrayList<String>> partitions) {
        for(ArrayList<String> i: partitions) {
            for(String j : i) {
                System.out.print(j + "|");
            }
            System.out.println();
        }
    }
}
