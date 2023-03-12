package com.recursion;

public class PossibleBSTCountFromKey {

    public static void main(String[] args) {
        System.out.println("Total BST: " + countBST(12));
    }

    public static int countBST(int n) {
        int result = 0;

        if (n == 0 || n == 1) {
            return 1;
        }

        for (int i = 1 ; i <= n ; i++) {
             result += countBST(i - 1) * countBST(n - i);
        }

        return result;
    }
}
