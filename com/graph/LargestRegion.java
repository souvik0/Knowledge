package com.graph;

public class LargestRegion {

    public static int count;
    public static void main(String[] args) {
        int M[][] = {{0, 0, 1, 1, 0},
                     {1, 0, 1, 1, 0},
                     {0, 1, 0, 0, 0},
                     {0, 0, 0, 0, 1}};
        System.out.println(largestRegion(M));
    }

    public static int largestRegion(int[][] m) {
        boolean[][] visited = new boolean[m.length][m[0].length];
        int largestRegion = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == 1 && !visited[i][j]) {
                   count = 1;
                   DFSUtil(m, visited, i, j);
                   largestRegion = Math.max(largestRegion, count);
                }
            }
        }
        return largestRegion;
    }

    public static void DFSUtil(int[][] m, boolean[][] visited, int row, int col) {
        visited[row][col] = true;

        int[] Path_Row = new int[] {1, -1, 0, 0, 1, 1, -1, -1};
        int[] Path_Col = new int[] {0, 0, 1, -1, 1, -1, 1, -1};

        for (int k = 0; k < Path_Row.length; k++) {
            int rowNext = row + Path_Row[k];
            int colNext = col + Path_Col[k];
            if (isSafeToMove(m, visited, rowNext, colNext)) {
                count++;
                DFSUtil(m, visited, rowNext, colNext);
            }
        }
    }

    public static boolean isSafeToMove(int m[][], boolean visited[][], int row, int col) {
        return (row >= 0) && (row < m.length) && (col >= 0) && (col < m[0].length) &&
               (m[row][col] == 1 && !visited[row][col]);
    }
}
