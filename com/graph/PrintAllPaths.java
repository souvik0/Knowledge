package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// This gets solved using DFS approach
public class PrintAllPaths {

    private int V; // No. of vertices
    // This is adjacency List representation. This representation is actually stands as
    // List<LinkedList<Integer>>
    private List<Integer> adj[];

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public PrintAllPaths(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    // Prints all paths from
    // 's' to 'd'
    public void printAllPaths(int source, int destination) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> pathList = new ArrayList<>();
 
        // add source to path[]
        pathList.add(source);
 
        // Call recursive utility
        printAllPathsUtil(source, destination, visited, pathList);
    }

    public void printAllPathsUtil(Integer source, Integer destination, boolean[] visited,
                                  List<Integer> localPathList) {
        // Recursion break condition same RatInMaze problem
        if (source.equals(destination)) {
            System.out.println(localPathList);
            // if match found then no need to traverse more till depth
            return;
        }

        visited[source] = true;

        // Recur for all the vertices adjacent to current vertex
        for (Integer neighbour : adj[source]) {
            if (!visited[neighbour]) {
                // store current node in path[]
                localPathList.add(neighbour);
                printAllPathsUtil(neighbour, destination, visited, localPathList);

                // remove current node in path[] for backtracking
                localPathList.remove(neighbour);
            }
        }
        // Mark the current node
        visited[source] = false;
    }

    // Driver program
    public static void main(String[] args) {
        // Create a sample graph
    	PrintAllPaths g = new PrintAllPaths(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        // arbitrary source
        int s = 2;

        // arbitrary destination
        int d = 3;

        System.out.println("Following are all different paths from " + s + " to " + d);
        g.printAllPaths(s, d);
    }
}
