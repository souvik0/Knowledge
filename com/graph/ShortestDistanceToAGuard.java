package com.graph;

/*
 * O ==> Open Space 
 * G ==> Guard
 * W ==> Wall
 */
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceToAGuard {

    int M = 5;
    int N = 5;
    int row[] = {-1, 0, 1, 0};
    int col[] = {0, 1, 0, -1};

    public class Node {
        int i, j, dist;
        Node(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        char matrix[][] = {{'O', 'O', 'O', 'O', 'G'},
                           {'O', 'W', 'W', 'O', 'O'},
                           {'O', 'O', 'O', 'W', 'O'},
                           {'G', 'W', 'W', 'W', 'O'},
                           {'O', 'O', 'O', 'O', 'G'}};

        ShortestDistanceToAGuard g = new ShortestDistanceToAGuard();
        g.findDistance(matrix);
    }

    public void findDistance(char[][] matrix) {
        int output[][] = new int[M][N];
        Queue<Node> q = new LinkedList<Node>();

        // Finding Guards location and adding into queue
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // Initialize each cell as -1
                output[i][j] = -1;
                if (matrix[i][j] == 'G') {
                    q.add(new Node(i, j, 0));
                    // Guard has 0 distance. So perform backtracking
                    output[i][j] = 0;
                }
            }
        }

        // Do till queue is empty
        while (!q.isEmpty()) {
            // Get the front cell in the queue and update its adjacent cells
            Node curr = q.peek();
            int x = curr.i;
            int y = curr.j;
            int dist = curr.dist;
            // Do for each adjacent cell
            for (int i = 0; i < 4; i++) {
                // If adjacent cell is valid, has path and not visited yet, en-queue it.
                if (isValid(x + row[i], y + col[i])) {
                    if (isSafe(x + row[i], y + col[i], matrix, output)) {
                        output[x + row[i]][y + col[i]] = dist + 1;
                        q.add(new Node(x + row[i], y + col[i], dist + 1));
                    }
                }
            }
            // Dequeue the front cell as its distance is found. It is also backtracking
            q.poll();
        }

        // Print output matrix
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Return true if row number and column number is in range
    public boolean isValid(int i, int j) {
        if ((i < 0 || i > M - 1) || (j < 0 || j > N - 1)) {
            return false;
        }
        return true;
    }

    // Return true if current cell is an open area and its distance
    // from guard is not calculated yet
    public boolean isSafe(int i, int j, char matrix[][], int output[][]) {
         if (matrix[i][j] != 'O' || output[i][j] != -1) {
             return false;
         }
         return true;
    }
}
