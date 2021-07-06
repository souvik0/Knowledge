package com.matrix;

/* 1. Transpose of matrix 
 * 2. Reverse columns
 * This approach rotate matrix 90 degree only once
* */
public class RotateMatrixAntiClockwise {

    public static void main(String[] args) {
        int mat[][] = {{1,2},{4,5}};
        System.out.println("The matrix before rotation");
        print_matrix(mat);
        System.out.println("Transpose of the matrix");
        transpose_matrix(mat);
        System.out.println("The matrix after rotation");
        reverse_columns(mat);
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
    public static void reverse_columns(int mat[][]) {
        // Here while traversing column needs to be fixed
        int k;
        for (int i = 0; i < mat.length; i++) {
            k = mat.length-1;
            for (int j = 0; j < k; j++) {
                int temp = mat[j][i];
                mat[j][i] = mat[k][i];
                mat[k][i] = temp;
                k--;
            }
        }
    }

    // Function to print the matrix
    public static void print_matrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j=0; j< mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
        System.out.print("\n");
        }
    }
}