package com.graph;

// Application of BFS

import java.util.LinkedList;
import java.util.List;

public class BipartiteCheck {

    public static void main(String[] args) {
    }

    private static int V; // No. of vertices
    private List<Integer> adj[];

    @SuppressWarnings({"unchecked", "rawtypes"})
    public BipartiteCheck(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int vertex, int edge) {
        adj[vertex].add(edge); // Add w to v's list.
    }

    public static boolean isBipartite(int G[][]) {
        /* Create a color array to store colors assigned to all vertices.
         * Vertex/ number is used as index in this array. The value '-1' of colorArr[i] is
         * used to indicate that no color is assigned to vertex 'i'.
         * The value 1 is used to indicate first color is assigned and value
         * 0 indicates second color is assigned.
         */
        int colorArr[] = new int[V];
        for (int i = 0; i < V; ++i)
            colorArr[i] = -1;

        // This code is to handle disconnected graph
        for (int i = 0; i < V; i++) {
            if (colorArr[i] == -1) {
                if (isBipartiteUtil(G, i, colorArr) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isBipartiteUtil(int G[][], int src, int colorArr[]) {
        colorArr[src] = 1;
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(src);
        while (!q.isEmpty()) {
            int u = q.getFirst();
            q.pop();

            // Return false if there is a self-loop
            if (G[u][u] == 1) {
                return false;
            }

            // Find all non-colored adjacent vertices
            for (int v = 0; v < V; ++v) {
                // An edge from u to v exists and
                // destination v is not colored
                if (G[u][v] == 1 && colorArr[v] == -1) {
                    // Assign alternate color to this adjacent v of u
                    colorArr[v] = 1 - colorArr[u];
                    q.push(v);
                }
                /* An edge from u to v exists and destination v is colored with same
                / color as u */
                else if (G[u][v] == 1 && colorArr[v] == colorArr[u]) {
                    return false;
                }
            }
        }
        return true;
    }
}
