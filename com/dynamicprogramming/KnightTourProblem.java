package com.dynamicprogramming;

public class KnightTourProblem {

    public static int N = 8;

    /* A utility function to check if i,j are
       valid indexes for N*N chessboard. Knight can traverse multiple times on a particular grid */
    public static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    /* A utility function to print solution
       matrix sol[N][N] */
    public static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(sol[x][y] + " ");
            }
            System.out.println();
        }
    }

    /* This function solves the Knight Tour problem
       using Backtracking.  This  function mainly
       uses solveKTUtil() to solve the problem. It
       returns false if no complete tour is possible,
       otherwise return true and prints the tour.
       Please note that there may be more than one
       solutions, this function prints one of the
       feasible solutions.  */
    public static void solveKT() {
        int sol[][] = new int[N][N];

        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }
        /* xMove[] and yMove[] define next move of Knight.
           xMove[] is for next value of x coordinate
           yMove[] is for next value of y coordinate */
        int rowMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int colMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // Since the Knight is initially at the first block
        sol[0][0] = 0;

        /* Start from 0,0 and explore all tours using
           solveKTUtil() */
        if (!solveKTUtil(0, 0, 0, sol, rowMove, colMove)) {
            System.out.println("Solution does not exist");
        }
        else {
            printSolution(sol);
        }
    }

    /* A recursive utility function to solve Knight
       Tour problem */
    public static boolean solveKTUtil(int row, int col, int movePointer, int sol[][], int rowMove[], int colMove[]) {
        // Recursion break condition
        if (movePointer == N * N) {
            return true;
        }

        /* Try all next moves from the current coordinate x, y */
        for (int k = 0; k < rowMove.length; k++) {
            int next_row = row + rowMove[k];
            int next_col = col + colMove[k];

            if (isSafe(next_row, next_col, sol)) {
                movePointer++;
                sol[next_row][next_col] = movePointer;
                if (solveKTUtil(next_row, next_col, movePointer, sol, rowMove, colMove)) {
                    return true;
                }
                else {// backtracking. Initialize with the initial value
                  sol[next_row][next_col] = -1;
                }
            }
        }

        return false;
    }

    /* Driver Code */
    public static void main(String args[]) {
        // Function Call
        solveKT();
    }
}