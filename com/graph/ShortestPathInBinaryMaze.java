package com.graph;

public class ShortestPathInBinaryMaze {

    static boolean[][] visited;
    public static void main(String[] args) {
        int[][] mat = new int[][] {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                                   {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                                   {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                                   {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                                   {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                                   {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                                   {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                   {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                                   {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};
        int[] src = {0, 0};
        int[] dest = {3, 4};
        int dist = findShortestPathLength(mat, src, dest);
        if (dist != -1) {
            System.out.print("Shortest Path is " + dist);
        } else {
            System.out.print("Shortest Path doesn't exist");
        }
    }

    public static int findShortestPathLength(int[][] mat, int[] src, int[] dest) {
        // If source & destination both are not reachable
        if (mat.length == 0 || mat[src[0]][src[1]] == 0 || mat[dest[0]][dest[1]] == 0) {
            return -1;
        }

        int row = mat.length;
        int col = mat[0].length;

        // construct an `M × N` matrix to keep track of visited cells
        visited = new boolean[row][col];

        int min_dist = Integer.MAX_VALUE;
        min_dist = findShortestPath(mat, src[0], src[1], dest[0], dest[1], min_dist, 0);

        if (min_dist != Integer.MAX_VALUE) {
            return min_dist;
        }

        return -1;
    }

    public static int findShortestPath(int[][] mat, int startRow, int startCol,
                                       int destRow, int destCol, int min_dist, int dist) {
        if (startRow == destRow && startCol == destCol) {
            min_dist = Math.min(dist, min_dist);
            return min_dist;
        }
        // set (i, j) cell as visited
        visited[startRow][startCol] = true;
        // go to the bottom cell
        if (isSafe(mat, visited, startRow + 1, startCol)) {
            min_dist = findShortestPath(mat, startRow + 1, startCol,
                                        destRow, destCol, min_dist, dist + 1);
        }
        // go to the right cell
        if (isSafe(mat, visited, startRow, startCol + 1)) {
            min_dist = findShortestPath(mat, startRow, startCol + 1,
                                        destRow, destCol, min_dist, dist + 1);
        }
        // go to the top cell
        if (isSafe(mat, visited, startRow - 1, startCol)) {
            min_dist = findShortestPath(mat, startRow - 1, startCol,
                                        destRow, destCol, min_dist, dist + 1);
        }
        // go to the left cell
        if (isSafe(mat, visited, startRow, startCol - 1)) {
            min_dist = findShortestPath(mat, startRow, startCol - 1,
                                        destRow, destCol, min_dist, dist + 1);
        }

        // backtrack: remove (i, j) from the visited matrix
        visited[startRow][startCol] = false;

        return min_dist;
    }

    // Check if it is possible to go to (x, y) from the current position.
    // The function returns false if the cell has value 0 or already visited
    public static boolean isSafe(int[][] mat, boolean[][] visited, int x, int y) {
      return (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length &&
              mat[x][y] == 1 && !visited[x][y]);
    }
}
