package com.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// This will detect presence of cycle using DFS in an undirected graph
public class DetectCycle {

     private int V; // No. of vertices
    // This is adjacency List representation. This representation is actually stands as
    // List<LinkedList<Integer>>
    private List<Integer> adj[];

    @SuppressWarnings({ "unchecked", "rawtypes"})
    public DetectCycle(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    // Returns true if the graph contains a cycle, else false.
    public Boolean isCyclic() {

        // Mark all the vertices as not visited and not part of recursion stack
        boolean visited[] = new boolean[V];

        // Call the recursive helper
        // function to detect cycle in
        // different DFS trees
        for (int u = 0; u < V; u++) {
            // Don't recur for u if already visited
            if (!visited[u]) {
                if (isCyclicUtil(u, visited, -1)) {
                    return true;
                }
            }
        }
 
        return false;
    }

    // A recursive function that
    // uses visited[] and parent to detect
    // cycle in subgraph reachable
    // from vertex v.
    public Boolean isCyclicUtil(int v, boolean visited[], int parent){
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices
        // adjacent to this vertex
        Iterator<Integer> itr = adj[v].iterator();
        while (itr.hasNext()) {
            i = itr.next();

            // If an adjacent is not
            // visited, then recur for that
            // adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v)) {
                    return true;
                }
            }

            // If an adjacent is visited
            // and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent) {
                return true;
            }

        }
        return false;
    }

    // Driver method to test above methods
    public static void main(String args[]) {
        // Create a graph given
        // in the above diagram
        DetectCycle g1 = new DetectCycle(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }

        DetectCycle g2 = new DetectCycle(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }
    }
}
