package com.recursion;

import java.util.Vector;

public class FindCombination {

    public static Vector<Vector<Integer>> ans = new Vector<Vector<Integer>>();
    public static Vector<Integer> tmp = new Vector<Integer>();

    public static void main(String[] args) {
        // given number
        int n = 5; // Range
        int k = 2; // Digits in the number
        ans = makeCombi(n, k);
    }

    public static Vector<Vector<Integer>> makeCombi(int n, int k) {
        makeCombiUtil(n, 1, k);
        return ans;
    }

    public static void makeCombiUtil(int n, int start, int k) {
        // Pushing this vector to a vector of vector
        if (k == 0) {
            ans.add(tmp);
            for (int i = 0; i < tmp.size(); i++) {
                System.out.print(tmp.get(i) + " ");
            }
            System.out.println();
            return;
        }

        // i iterates from left to n. First time left will be 1
        for (int i = start; i <= n; ++i) {
            tmp.add(i);
            makeCombiUtil(n, i + 1, k - 1);
            // Popping out last inserted element from the vector using Backtracking
            tmp.remove(tmp.size() - 1);
        }
    }
}
