package com.graph;

/* Time Complexity: O(V + E)
   Auxiliary Space: O(V) */

import java.util.ArrayList;
import java.util.List;

public class FindMotherVertex {

    public static void addEdge(int u, int v, ArrayList<ArrayList<Integer> > adj) {
        adj.get(u).add(v);
    }

    public static List<Integer> motherVertex(ArrayList<ArrayList<Integer> > adj, int V) {
        List<Integer> motherVertexList = new ArrayList<Integer>();
        boolean[] visited = new boolean[V];
        int v = -1; // To store last finished vertex (or mother vertex)

        for (int i = 0 ; i < V; i++) {
             if (!visited[i]) {
                 DFSUtil(adj, i, visited);
                 v = i;
             }
        }

        /* If there exist mother vertex (or vertices) in the given graph, then v must be one
           (or one of them).

           Now check if v is actually a mother vertex (or graph has a mother vertex).
           We basically check if every vertex is reachable from v or not.

           Reset all values in visited[] as false and do DFS beginning from v to check
           if all vertices are reachable from it or not.
        */

        boolean[] check = new boolean[V];
        DFSUtil(adj, v, check);
        /* If all the vertices are being visited from this vertex, then all elements must be
         * true in check[]. If anyone of them is false, that means the vertex isn't 
         * the mother vertex.
         */
        for (boolean val : check) {
            if (!val) {
                motherVertexList.add(-1);
            }
        }

        motherVertexList.add(v);
        return motherVertexList;
    }

    // A recursive function to print DFS starting from v
    public static void DFSUtil(ArrayList<ArrayList<Integer> > adj, int source, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[source] = true;

        // Recur for all the vertices adjacent to this vertex
        for (int x : adj.get(source)) {
            if (!visited[x]) {
                DFSUtil(adj, x, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;

        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(0, 1, adj);
        addEdge(0, 2, adj);
        addEdge(1, 3, adj);
        addEdge(4, 1, adj);
        addEdge(6, 4, adj);
        addEdge(5, 6, adj);
        addEdge(5, 2, adj);
        addEdge(6, 0, adj);

        System.out.println("A mother vertex is " + motherVertex(adj, V).toString());
    }
}
