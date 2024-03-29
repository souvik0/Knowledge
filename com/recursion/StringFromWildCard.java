package com.recursion;

/* Time complexity: Best case: O(n)
                  : Worst case: O(2^n) 
*/
public class StringFromWildCard {

    public static void main(String[] args) {
        char[] pattern = "1?0?".toCharArray();
        printAllCombinations(pattern, 0);
    }

    private static void printAllCombinations(char[] pattern, int start) {
        // base case
        if (pattern == null || pattern.length == 0) {
            return;
        }

        // base case or recursion break condition
        if (start == pattern.length) {
            System.out.println(pattern);
            return;
        }

        // if the current character is '?'
        if (pattern[start] == '?') {
            for (char ch = '0'; ch <= '1'; ch++) {
                // replace '?' with 0 and 1
                pattern[start] = ch;

                // recur for the remaining pattern
                printAllCombinations(pattern, start + 1);

                // backtrack to find out next combination
                pattern[start] = '?';
            }
        } else {
            // if the current character is 0 or 1, ignore it and
            // recur for the remaining pattern
            printAllCombinations(pattern, start + 1);
        }
    }
}
