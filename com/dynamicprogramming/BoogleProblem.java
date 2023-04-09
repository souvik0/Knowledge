package com.dynamicprogramming;

// It is also termed as Chinese Checker problem
import java.util.ArrayList;
import java.util.List;

public class BoogleProblem {

    public static void findWord(char[][] board, boolean[][] visited, int startRow, int startCol, String word,
                         List<String> englishDictionary) {

        // Define all possible move directions
        int[] Path_Row = {0, 0, 1, 1, -1, 1, -1, -1};
        int[] Path_Col = {1, -1, -1, 1, 1, 0, 0, -1};

        if (englishDictionary.contains(word)) {
            System.out.println(word);
        }

        for (int index = 0; index < Path_Row.length; index++) {
             int rowNew = startRow + Path_Row[index];
             int colNew = startCol + Path_Col[index];
             if (isValidMove(rowNew, colNew, visited, board)) {
                 visited[rowNew][colNew] = true;
                 findWord(board, visited, rowNew, colNew, word + board[rowNew][colNew], englishDictionary);
                 // Backtracking logic goes here to validate multiple words
                 visited[rowNew][colNew] = false;
             }
        }
    }

    public static boolean isValidMove(int row, int col, boolean[][] visited, char[][] board) {
        if ((row >= 0) && (row < board.length) && (col >= 0) && (col < board[0].length) && !visited[row][col]) {
             return true;
        } else {
             return false;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'G', 'I', 'Z'},
                          {'U', 'E', 'K'},
                          {'Q', 'S', 'E'}};

        boolean[][] visited = new boolean[board.length][board[0].length];

        List<String> englishDictionary = new ArrayList<String>();
        englishDictionary.add("GEEKS");
        englishDictionary.add("QUIZ");
        englishDictionary.add("FOR");
        englishDictionary.add("GO");

        String word = "";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0 ; j < board[0].length; j++) {
                 findWord(board, visited, 0, 0, word + board[i][j], englishDictionary);
            }
        }
    }
}