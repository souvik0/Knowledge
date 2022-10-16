package com.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstTraversal {

    private int V; // No. of vertices
    private LinkedList<Integer> adj[];

    // Constructor
    @SuppressWarnings({ "unchecked", "rawtypes" }) 
    public DepthFirstTraversal (int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int edge) {
        adj[v].add(edge); // Add w to v's list.
    }

    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    public void DFS(int v) {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }

    // A function used by DFS
    public void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> itr = adj[v].listIterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // Driver's Code
    public static void main(String args[]) {
       DepthFirstTraversal g = new DepthFirstTraversal(4);

       g.addEdge(0, 1);
       g.addEdge(0, 2);
       g.addEdge(1, 2);
       g.addEdge(2, 0);
       g.addEdge(2, 3);
       g.addEdge(3, 3);

        System.out.println(
            "Following is Depth First Traversal "
            + "(starting from vertex 2)");

        // Function call
        g.DFS(2);
    }
}
