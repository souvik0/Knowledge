package dynamicprogramming;

// Here we can move only in right & bottom direction
// if there is diagonal movement also add count[i-1][j-1] in the final result
// This is an m*n matrix
public class TotalWaysInMatrix {

    public static void main(String[] args) {
        System.out.println(getTotalWaysInMatrix(5, 4)); 
    }

    public static int getTotalWaysInMatrix(int row, int column) {
        // Initialize temp matrix with m rows & n column
        int[][] T = new int[row][column];

        // Fill up first column with 1
        for (int i = 0; i < row; i++) {
            T[i][0] = 1;
        }

        // Fill up first row with 1
        for (int i = 0; i < column; i++) {
            T[0][i] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                 T[i][j] = T[i-1][j] + T[i][j-1];
            }
        }
        // Last cell of the matrix represent total ways to reach end from start
        return T[row-1][column-1];
    }
}