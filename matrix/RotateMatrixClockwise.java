package matrix;

/* This approach is applicable to square matrix only
 * 1. Transpose of matrix 
 * 2. Reverse rows
 * This approach rotate matrix 90 degree only once
 * */
public class RotateMatrixClockwise {

    public static void main(String[] args) {
        int mat[][] = {{1,2,},{4,5,}};
        System.out.println("The matrix before rotation ");
        print_matrix(mat);
        System.out.println("Transpose of the matrix ");
        transpose_matrix(mat);
        System.out.println("The matrix after rotation ");
        reverse_rows(mat);
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
        // Here while traversing, row needs to be fixed
        int k;
        for (int i = 0; i < mat.length; i++) {
            k = mat.length - 1;
            for (int j = 0; j < k; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][k];
                mat[i][k] = temp;
                k--;
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
