package com.matrix;

/* This approach is applicable to square matrix only
 * 1. Transpose of matrix 
 * 2. Reverse rows / Reverse Column
 * This approach rotate matrix 90 degree only once
 * */
public class RotateMatrixAllDirection {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 9}};

        System.out.println("The matrix after rotation ");
        transpose_matrix(mat);
        //reverse_rows(mat);
        reverse_col(mat);
        print_matrix(mat);
    }

    public static void transpose_matrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat.length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    // Function to reverse rows of the matrix
    public static void reverse_rows(int mat[][]) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void reverse_col(int mat[][]) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = mat[left][i];
                mat[left][i] = mat[right][i];
                mat[right][i] = temp;
                left++;
                right--;
            }
        }
    }

    // Function to print the matrix
    public static void print_matrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
