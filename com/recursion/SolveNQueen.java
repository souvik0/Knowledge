package com.recursion;

public class SolveNQueen {

    final int N = 4;

    public static void main(String[] args) {
        SolveNQueen nQueenProblem = new SolveNQueen();
        nQueenProblem.solveNQueen();
    }

    public boolean solveNQueen() {
        int board[][] = {{0, 0, 0, 0},
                         {0, 0, 0, 0},
                         {0, 0, 0, 0},
                         {0, 0, 0, 0}};

        if (solveNQueenUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    /* A recursive utility function to solve N
       Queen problem 
    */
    public boolean solveNQueenUtil(int board[][], int col) {
        /* base case: If all queens are placed
           then return true
        */
        if (col >= N) {
            return true;
        }

        /* Consider this column and try placing
           this queen in all rows one by one 
        */
        for (int i = 0; i < N; i++) {
            /* Check if the queen can be placed on
               board[i][col]
            */
            if (isSafe(board, i, col)) {
               /* Place this queen in board[i][col] */
               board[i][col] = 1;

               /* recur to place rest of the queens */
               if (solveNQueenUtil(board, col + 1) == true) {
                   return true;
               }

               /* If placing queen in board[i][col]
                  doesn't lead to a solution then
                  remove queen from board[i][col] 
               */
               board[i][col] = 0; // BACKTRACK
            }
        }

        /* If the queen can not be placed in any row in
           this column col, then return false
        */
        return false;
    }

    /* A utility function to check if a queen can
       be placed on board[row][col]. Note that this
       function is called when "col" queens are already
       placed in columns from 0 to col -1. So we need
       to check only left side for attacking queens
    */
    public boolean isSafe(int board[][], int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    /* A utility function to print solution */
    public void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }
}
