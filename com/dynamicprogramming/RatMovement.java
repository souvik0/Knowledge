package com.dynamicprogramming;
// Here rat can move in left, right, bottom & up direction by 1 step each
// This is adjacency matrix representation of a graph.
// This problem can be solved using DFS traversal along with backtracking
// Backtracking is required to determine next set of paths.
// This is determining paths between source & destination vertex.

public class RatMovement {

    public static void main(String[] args) {
        int maze[][] = {{1, 1, 0, 1},
                        {0, 1, 1, 1},
                        {0, 1, 0, 1},
                        {0, 1, 1, 1}};

        // VISITED ARRAY WILL KEEP TRACK OF VISIT BY RAT & HAVING SAME LENGTH OF ORIGINAL MAZE
        int[][] visited = new int[maze.length][maze[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = 0;
            }
        }
       // move marked as 1 denoted that rat in already in the starting cell
        pathInMaze(maze, visited, 1, 2, 2, 1, 1);
    }

    public static void pathInMaze(int[][] maze, int[][] visited, int startRow, int startCol,
                                   int destRow, int destCol, int movePointer) {
        if ((startRow == 0) && (startCol == 0)) {
            visited[startRow][startCol] = movePointer;
        }

        // Recursion break condition
        if ((startRow == destRow) && (startCol == destCol)) {
            printSolution(visited);
        } else {
            // Determine rat's possible movements
            int[] Path_Row = {0, 0, 1, -1};
            int[] Path_Col = {1, -1, 0, 0};

            for (int index = 0; index < Path_Row.length; index++) {
                int rowNext = startRow + Path_Row[index];
                int colNext = startCol + Path_Col[index];
                // Rat can move only once in a cell while visiting
                if (canRatMove(maze, visited, rowNext, colNext)) {
                    movePointer++;
                    visited[rowNext][colNext] = movePointer;
                    // This is the recursive DFS call
                    pathInMaze(maze, visited, rowNext, colNext, destRow, destCol, movePointer);
                    // This is where we are doing backtracking.
                    // should go back to initial value of how visited array was created
                    // This needs to be done to get multiple paths
                    movePointer--;
                    visited[rowNext][colNext] = 0;
                }
            }
        }
    }

    public static boolean canRatMove(int[][] maze, int[][] visited, int rowNext, int colNext) {
        // If any cell in maze marked as 0, then that is not movable cell.
        // If already visited a cell in visited matrix, then it can't be visited twice
        if ((rowNext >= 0) && (rowNext < maze.length) && (colNext >= 0) && (colNext < maze[0].length) &&
            maze[rowNext][colNext] == 1 && visited[rowNext][colNext] == 0) {
                return true;
        } else {
           return false;
        }
    }

    public static void printSolution(int visited[][]) {
        for (int i = 0; i < visited.length; i++) { 
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print(" " + visited[i][j] + " "); 
            }
            System.out.println();
        }
        System.out.println("////////////////////////");
    }
}