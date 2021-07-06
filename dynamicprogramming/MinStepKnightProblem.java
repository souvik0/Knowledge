package com.dynamicprogramming;

// This problem can be viewed as BFS traversal from start to destination in a matrix
// Matrix cells can be represented as graph nodes
import java.util.LinkedList;
import java.util.Queue;

public class MinStepKnightProblem {

    static class Cell {
        int x;
        int y;
        // additional property to count steps
        int distance;

        public Cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int minMove(int n, int startRow, int startColumn, int destRow, int destColumn) {
        // Single dimensional array to represent knight's starting position
        int knightPosition[] = {startRow, startColumn};
        // Single dimensional array to represent knight's target position
        int targetPosition[] = {destRow, destColumn};

        return getMinJumps(n, knightPosition, targetPosition);
    }

    public int getMinJumps(int n, int[] knightPosition, int[] targetPosition) {
        // Define all possible directional moves by knight
        int[] dx = {2, -2, 1, -1, -1, 1, -2, 2};
        int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

        // Initializing queue & visited array with false
        Queue<Cell> queue = new LinkedList<Cell>();

        boolean[][] visited = new boolean[n+1][n+1];
        for (int i= 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                visited[i][j] = false;
            }
        }

        // Adding starting cell in the queue & mark it true in visited array
        queue.add(new Cell(knightPosition[0], knightPosition[1], 0));
        visited[knightPosition[0]][knightPosition[1]] = true;

        // Level order traversal / BFS traversal
        while (!queue.isEmpty()) {
            Cell popedCell = queue.poll();

            if (popedCell.x == targetPosition[0] && popedCell.y == targetPosition[1]) {
                return popedCell.distance;
            }

            // Loop for all directions to find out x & y coordinates
            // As popped cell is the start row, so new row & column will come as adding with popedCell.
            for (int i = 0 ; i < dx.length; i++) {
                int next_x = popedCell.x + dx[i];
                int next_y = popedCell.y + dy[i];

                // If that coordinate falls with chase board, mark that as visited & add to queue
                if (isValidMove(next_x, next_y, n, visited)) {
                    // Every time distance increases by 1
                    queue.add(new Cell(next_x, next_y, popedCell.distance + 1));
                    visited[next_x][next_y] = true;
                }
            }
        }
        return -1;
    }

    public boolean isValidMove(int x, int y, int n, boolean[][] visited) {
        if ((x >=1) && (x <= n) && (y >=1) && (y <= n) && !visited[x][y]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MinStepKnightProblem minStepKnightProblem = new MinStepKnightProblem();
        int mimimumSteps = minStepKnightProblem.minMove(30, 4, 5, 16, 22);
        System.out.println("Minimum no of steps required : " + mimimumSteps);
    }
}