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
        char[][] grid = {{'G', 'W', 'G', 'G', 'G'},
                         {'W', 'W', 'W', 'W', 'W'},
                         {'G', 'W', 'G', 'W', 'G'},
                         {'G', 'W', 'W', 'W', 'G'},
                         {'G', 'G', 'G', 'G', 'G'}};

        int result = shortestDistance(grid);
        System.out.println("Shortest distance to a guard: " + result);
    }

    public static int shortestDistance(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1; // Invalid input
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distance = new int[rows][cols];
        int guardCount = 0;

        // Find all guards and initialize the distance matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'G') {
                    guardCount++;
                    bfs(grid, distance, i, j);
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;

        // Find the minimum distance to a guard from each empty cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0' + guardCount && distance[i][j] > 0) {
                    minDistance = Math.min(minDistance, distance[i][j]);
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private static void bfs(char[][] grid, int[][] distance, int startX, int startY) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            // Explore neighbors
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY] && grid[newX][newY] != 'W') {
                    queue.offer(new int[]{newX, newY, dist + 1});
                    visited[newX][newY] = true;
                }
            }
        }
    }
}
