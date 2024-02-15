package com.matrix;

// The given matrix is in sorted order

public class MaxOnesRow {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 1},
                          {0, 0, 1, 1},
                          {1, 1, 1, 1},
                          {0, 0, 0, 0}};

        int rowWithMaxOnes = findRowWithMaxOnes(matrix);
        System.out.println("Row with maximum 1s: " + rowWithMaxOnes);
    }

    public static int findRowWithMaxOnes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxOnesCount = 0;
        int maxOnesRow = -1;

        for (int i = 0; i < rows; i++) {
            // This value needs to reinitialized after every row
            int onesCount = 0;

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    onesCount++;
                }
            }

            if (onesCount > maxOnesCount) {
                maxOnesCount = onesCount;
                maxOnesRow = i;
            }
        }

        return maxOnesRow;
    }
}
