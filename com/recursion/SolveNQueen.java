package com.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolveNQueen {

    public static void main(String[] args) {
        int N = 4;
        List<List<String>> queen = solveNQueens(N);
        int i = 1;

        for (List<String> it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        // Initialize board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> resultList = new ArrayList <List<String>>();
        dfs(0, board, resultList);
        return resultList;
    }

    public static void dfs(int col, char[][] board, List<List<String>> resultList) {
        if (col == board.length) {
            resultList.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, resultList);
                // Here backtracking taking place to evaluate other combinations
                board[row][col] = '.';
            }
        }
    }

    public static List<String> construct(char[][] board) {
        List<String> resultList = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            resultList.add(s);
        }
        return resultList;
    }

    public static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
            row++;
        }
        return true;
    }
}
