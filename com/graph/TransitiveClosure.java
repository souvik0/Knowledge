package com.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Here source & destination is given to find out the paths in the graph.

public class TransitiveClosure {

    private int V; // No. of vertices

    /* This is adjacency List representation. This representation is actually stands as
       List<List<Integer>>.
       Actual structure looks like LinkedList<LinkedList<Integer>>
    */
    private List<Integer> adj[];

    // To keep track of transitive path matrix or reachability matrix
    private int[][] tc;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public TransitiveClosure(int v) {
        this.V = v;
        adj = new LinkedList[v];
        this.tc = new int[this.V][this.V];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int vertex, int edge) {
        adj[vertex].add(edge); // Add w to v's list.
    }

    public void transitiveClosure( ) {
        /* Call the recursive helper function to print DFS traversal starting from all
           vertices one by one 
        */
        for (int i = 0; i < V; i++) {
            dfsUtil(i, i);
        }

        for (int i = 0; i < V; i++) {
          System.out.println(Arrays.toString(tc[i]));
        }
    }

    private void dfsUtil(int source, int destination) {
        // Mark reachability from s to v as true.
       if (source == destination){
           tc[source][destination] = 1;
       } else {
           tc[source][destination] = 1;
       }

        // Find all the vertices reachable through destination
        for (int x : adj[destination]) {
            if (tc[source][x] == 0) {
                dfsUtil(source, x);
            }
        }
    }

    public static void main(String[] args) {

        // Create a graph given in the above diagram
        TransitiveClosure g = new TransitiveClosure(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Transitive closure matrix is");

        g.transitiveClosure();
    }
}
