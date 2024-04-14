package com.graph;

/*
 * . ==> Open Space 
 * G ==> Guard
 * W ==> Wall
 */
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceToAGuard {

    public static void main(String[] args) {
        char[][] grid = {{'O', 'O', 'O', 'O', 'G'},
                         {'O', 'W', 'W', 'O', 'O'},
                         {'O', 'O', 'O', 'W', 'O'},
                         {'G', 'W', 'W', 'W', 'O'},
                         {'O', 'O', 'O', 'O', 'G'}};

        int[][] result = shortestDistanceToGuard(grid);
        printResult(result);
    }

    public static int[][] shortestDistanceToGuard(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return null;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n]; // Default value with 0

        Queue<int[]> queue = new LinkedList<>();

        // Add all guard cells to the queue and mark them as visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'G') {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Possible directions for BFS
        int[][] dirs = {{-1, 0},
                        {1, 0},
                        {0, -1},
                        {0, 1}};

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                   (grid[newRow][newCol] == 'O' || grid[newRow][newCol] == 'D')) {
                    if (grid[newRow][newCol] == 'O') {
                        result[newRow][newCol] = result[row][col] + 1;
                        grid[newRow][newCol] = 'D'; // Mark as visited
                        queue.offer(new int[]{newRow, newCol});
                    } else if (grid[newRow][newCol] == 'D') {
                        // If already visited, check if this path gives shorter distance
                        if (result[newRow][newCol] > result[row][col] + 1) {
                            result[newRow][newCol] = result[row][col] + 1;
                            queue.offer(new int[]{newRow, newCol});
                        }
                    }
                }
            }
        }

        return result;
    }

    // Helper function to print the result
    public static void printResult(int[][] result) {
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
