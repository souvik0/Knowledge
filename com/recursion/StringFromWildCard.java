package com.recursion;

/* Time complexity: Best case: O(n)
                  : Worst case: O(2^n) 
*/
public class StringFromWildCard {

    public static void main(String[] args) {
        char[] pattern = "1?0?".toCharArray();
        printAllCombinations(pattern, 0);
    }

    private static void printAllCombinations(char[] pattern, int i) {
        // base case
        if (pattern == null || pattern.length == 0) {
            return;
        }
        // base case
        if (i == pattern.length) {
            System.out.println(pattern);
            return;
        }
        // if the current character is '?'
        if (pattern[i] == '?') {
            for (char ch = '0'; ch <= '1'; ch++) {
                // replace '?' with 0 and 1
                pattern[i] = ch;

                // recur for the remaining pattern
                printAllCombinations(pattern, i + 1);

                // backtrack
                pattern[i] = '?';
            }
        } else {
            // if the current character is 0 or 1, ignore it and
            // recur for the remaining pattern
            printAllCombinations(pattern, i + 1);
        }
    }
}
