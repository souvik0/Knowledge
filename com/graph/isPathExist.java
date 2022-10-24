package com.graph;

// Time Complexity : O(V+E)

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class isPathExist {

    public static void main(String[] args) {
        isPathExist graph = new isPathExist(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        int u = 0, v = 3;
        if (graph.isReachable(u, v)) {
            System.out.println("There is a path from " + u +" to " + v);
        }
        else {
            System.out.println("There is no path from " + u +" to " + v);
        }
    }

    private int V; // No. of vertices
    // This is adjacency List representation. This representation is actually stands as
    // List<LinkedList<Integer>>
    private List<Integer>[] adj;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public isPathExist(int v) {
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

 // A BFS based function to check whether d is reachable from s.
    public boolean isReachable(int source, int destination) {
        // Base case
        if (source == destination) {
            return true;
        }

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            source = queue.remove();

            Iterator<Integer> itr = adj[source].listIterator();
            while (itr.hasNext()) {
                  int neighbour = itr.next();
                  if (source == neighbour) {
                      return true;
                  }
                  if (!visited[neighbour]) {
                      visited[neighbour] = true;
                      queue.add(neighbour);
                  }
            }
        }

        // If BFS is complete without visiting d
        return false;
    }
}
