package com.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DetectCycleDirectedGraphDFS {

    private int V; // No. of vertices
    // This is adjacency List representation. This representation is actually stands as
    // List<LinkedList<Integer>>
    private List<Integer>[] adj;

    @SuppressWarnings({"unchecked", "rawtypes" })
    public DetectCycleDirectedGraphDFS(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
             adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph
    public void addEdge(int vertex, int edge) {
        adj[vertex].add(edge);
    }

    // Returns true if the graph contains a
    // cycle, else false.
    // This function is a variation of DFS() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclic() {
        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    private boolean isCyclicUtil(int source, boolean[] visited, boolean[] recStack) {
        // Mark the current node as visited and part of recursion stack
        // Below two are the recursion break condition. 
        if (recStack[source]) {
            return true;
        }

        if (visited[source]) {
            return false;
        }

        visited[source] = true;
        recStack[source] = true;
        Iterator<Integer> itr = adj[source].iterator();

        while (itr.hasNext()) {
            Integer neighbor = itr.next();
            if (isCyclicUtil(neighbor, visited, recStack)) {
                return true;
            }
        }

        recStack[source] = false;

        return false;
    }

    public static void main(String[] args) {
        DetectCycleDirectedGraphDFS graph = new DetectCycleDirectedGraphDFS(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if (graph.isCyclic()) {
            System.out.println("Graph contains cycle");
        }
        else {
            System.out.println("Graph doesn't contain cycle");
        }
    }
}
