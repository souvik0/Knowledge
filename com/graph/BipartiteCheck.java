package com.graph;

// Application of BFS
// Here the graph is represented as adjacency matrix

import java.util.LinkedList;
import java.util.List;

public class BipartiteCheck {

    private static int V = 4; // No. of vertices

    public static void main(String[] args) {
        int G[][] = {{0, 1, 0, 1},
                     {1, 0, 1, 0},
                     {0, 1, 0, 1},
                     {1, 0, 1, 0}};

        if (BipartiteCheck.isBipartite(G, 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isBipartite(int G[][], int source) {
        /* Create a color array to store colors assigned to all vertices.
           Vertex number is used as index in this array. The value '-1'
           of colorArr[i] is used to indicate that no color is assigned
           to vertex 'i'. The value 1 is used to indicate first color
           is assigned and value 0 indicates second color is assigned.
        */
        int colorArr[] = new int[V];
        for (int i = 0; i < V; ++i) {
            colorArr[i] = -1;
        }

        // Assign first color to source
        colorArr[source] = 1;

        // Create a queue (FIFO) of vertex numbers
        // and enqueue source vertex for BFS traversal
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(source);

        // Run while there are vertices in queue (Similar to BFS)
        while (queue.size() != 0) {
            // Dequeue a vertex from queue
             source = queue.poll();

            // Return false if there is a self-loop
            if (G[source][source] == 1) {
                return false;
            }

            // Find all non-colored adjacent vertices
            for (int v = 0; v < V; ++v) {
                // An edge from u to v exists
                // and destination v is not colored
                if (G[source][v] == 1 && colorArr[v] == -1) {
                    // Assign alternate color to this adjacent v of u
                    colorArr[v] = 1 - colorArr[source];
                    queue.add(v);
                }

                // An edge from u to v exists and destination v is colored with same color as u
                else if (G[source][v] == 1 && colorArr[v] == colorArr[source]) {
                    return false;
                }
            }
        }

        // If we reach here, then all adjacent vertices can be colored with alternate color
        return true;
    }
}
