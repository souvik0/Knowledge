package com.dynamicprogramming;

// To find out minimum cost path from top left to bottom right.
// Only right & down direction is possible move
// If it supports diagonal movement, then additional condition will be written find out minimum of three numbers

public class MinimumCostPath {

    public static void main(String[] args) {
        int[][] cost = {
                       {4, 7, 8, 6, 4 },
                       {6, 7, 3, 9, 2 },
                       {3, 8, 1, 2, 4 },
                       {7, 1, 7, 3, 7 },
                       {2, 9, 8, 9, 3 }
                       };
        int m = cost.length;
        int n = cost[0].length;
        System.out.print("The minimum cost is " + findMinCostPath(cost, m, n));
    }

    public static int findMinCostPath(int[][] cost, int row, int column) {
        // base case
        if (row == 0 || column == 0) {
            return Integer.MAX_VALUE;
        }
 
        if (row == 1 && column == 1) {
           return cost[row][column];
        }

        // Include cost of the current cell in path and
        // recursion to find minimum of the path from adjacent
        // left cell and adjacent top cell.
        return cost[row - 1][column - 1] +
               Math.min(findMinCostPath(cost, row - 1, column),
                        findMinCostPath(cost, row, column - 1));
    }
}