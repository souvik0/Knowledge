package com.graph;

public class ReplaceOWithX {

    public static void main(String[] args) {
        char[][] matrix = {{'X', 'X', 'X', 'X'},
                           {'X', 'O', 'X', 'X'},
                           {'X', 'O', 'O', 'X'},
                           {'X', 'X', 'X', 'X'}};

        replaceSurroundedO(matrix);

        // Print the modified matrix
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void replaceSurroundedO(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Traverse the border of the matrix and mark 'O's and connected 'O's as visited
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 'O') {
                markVisited(matrix, i, 0);
            }
            if (matrix[i][cols - 1] == 'O') {
                markVisited(matrix, i, cols - 1);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 'O') {
                markVisited(matrix, 0, j);
            }
            if (matrix[rows - 1][j] == 'O') {
                markVisited(matrix, rows - 1, j);
            }
        }

        // Replace unvisited 'O's with 'X' and revert visited 'O's back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 'O') {
                    matrix[i][j] = 'X'; // Replacement
                // Backtracking to return to O as it is already visited but not surrounded by 'X'
                } else if (matrix[i][j] == 'V') {
                    matrix[i][j] = 'O';
                }
            }
        }
    }

    // This is similar to Flood-Fill algorithm
    private static void markVisited(char[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != 'O') {
            return;
        }

        matrix[i][j] = 'V'; // Mark 'O' as visited

        // DFS to mark connected 'O's as visited
        markVisited(matrix, i - 1, j);
        markVisited(matrix, i + 1, j);
        markVisited(matrix, i, j - 1);
        markVisited(matrix, i, j + 1);
    }
}
