package com.dynamicprogramming;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(char[] X, char[] Y, int m, int n) { 
        // Initialize a temporary matrix
        int T[][] = new int[m+1][n+1]; 
        /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
	         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i = 0; i <= m; i++) {
             for (int j = 0; j <= n; j++) {
                 if (i == 0 || j == 0) {
                     T[i][j] = 0; 
                 } else if (X[i-1] == Y[j-1]) {
                     T[i][j] = T[i-1][j-1] + 1; 
                 } else {
                     T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
                 }
             } 
        }
        // Last cell will return the length
        return T[m][n];
    }

    public static void main(String[] args) { 
        LongestCommonSubsequence lcs = new LongestCommonSubsequence(); 
        String s1 = "AGGTAB"; 
        String s2 = "GXTXAYB"; 

        char[] X=s1.toCharArray(); 
        char[] Y=s2.toCharArray(); 
        int m = X.length; 
        int n = Y.length; 
      
        System.out.println("Length of LCS is" + " " + 
                lcs.longestCommonSubsequence(X, Y, m, n )); 
    }
}