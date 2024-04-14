package com.recursion;

//Time Complexity : O(n*2^n)
import java.util.ArrayList;
// import java.util.List;

public class PalindromicDecompisition {

    public static void main(String[] args) {
        String s = "geeks";
        ArrayList<ArrayList<String>> finalList = new ArrayList<>();
        partition(s, finalList);
    }

    // Generates all palindromic partitions of 's' and
    // stores the result in 'v'.
    public static void partition(String s, ArrayList<ArrayList<String>> finalList) {
        // temporary ArrayList to store each palindromic string
        ArrayList<String> resultList = new ArrayList<>();

        // calling addString method it adds all 
        // the palindromic partitions to v
        finalList = addStrings(finalList, s, resultList, 0);

        // printing the solution
        printSolution(finalList);
    }

    // Goes through all indexes and recursively add remaining
    // partitions if current string is palindrome.
    public static ArrayList<ArrayList<String>> addStrings(ArrayList<ArrayList<String>> finalList,
           String s, ArrayList<String> resultList, int start) {

        int len = s.length();
        String str = "";
        // The same will be used in future for backtracking
        ArrayList<String> current = new ArrayList<>(resultList);

        // Iterate over the string
        for (int i = start; i < len; ++i) {
            // Partitioning individual characters from String
            str = str + s.charAt(i);

            // check whether the substring is palindromic or not
            if (checkPalindrome(str)) {
                // if palindrome add it to temp list
                resultList.add(str);

                if (i + 1 < len) {
                    // recurr to get all the palindromic partitions for the substrings
                    finalList = addStrings(finalList, s, resultList, i + 1);
                } else {
                    // if end of the string is reached add temp to v
                    finalList.add(resultList);
                }

                // temp is reinitialize with the current i as backtracking
                resultList = new ArrayList<>(current);
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
    public static void printSolution(ArrayList<ArrayList<String>> finalList) {
        for (ArrayList<String> eachList: finalList) {
            for (String j : eachList) {
                System.out.print(j + "|");
            }
            System.out.println();
        }
        // finalList.stream().flatMap(List::stream).forEach(System.out:: println);
    }
}
