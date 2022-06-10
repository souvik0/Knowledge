package com.dynamicprogramming;

// This can be solved using Fibonacci series approach
public class StaircaseProblem {

    public static void main(String[] args) {
        int s = 4, m = 2; 
        System.out.println("Number of ways = " + countWays(s, m));
    }

    public static int countWays(int s, int m) {
        // Considering s+1 because ground stairs also needs to be considered
        return countWyasUtil(s + 1, m);
    }

    public static int countWyasUtil(int n, int m) {
        if (n <= 1) {
            return 1;
        }

        int result = 0;
        for (int k = 1; k <= m && k <= n ; k++) {
             // Every time we reached one step ahead, count of steps will go down
             result = result + countWyasUtil(n - k, m);
        }
        return result;
    }
}