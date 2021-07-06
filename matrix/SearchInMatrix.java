package com.matrix;

// Search in a row-wise, column-wise sorted matrix
public class SearchInMatrix {

    public static void main(String[] args) {
        int matrix[][] = {{10, 20, 30, 40},
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 50}};
        System.out.println(search(matrix, 48));
    }

    public static boolean search(int[][] matrix, int number) {
        int row = matrix.length;
        int column = matrix[0].length;

        // combination of i & j will point to top right corner element
        int i = 0;
        int j = column - 1;

        while (i < row && j >= 0) {
            // Considering top right element
            if (matrix[i][j] == number) {
               System.out.println("Row :" + i + " column :" +j);
               return true;
            } else if (matrix[i][j] > number) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}