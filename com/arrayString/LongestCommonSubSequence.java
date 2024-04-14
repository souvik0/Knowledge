package com.arrayString;

// To determine length of longest common subsequence
public class LongestCommonSubSequence {

    public static void main(String[] args) {
        String text1 = "abcdefghi";
        String text2 = "aceh";
        int lengthOfLCS = longestCommonSubsequence(text1, text2);
        System.out.println("Length of Longest Common Subsequence: " + lengthOfLCS);
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Create a 2D array to store the lengths of LCS for substrings
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array using bottom-up dynamic programming approach
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Common character found, increment the length of LCS
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Choose the maximum of previous lengths
                }
            }
        }

        return dp[m][n]; // Return the length of LCS
    }
}
