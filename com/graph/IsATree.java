package com.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* Thre graph will be considered as Tree if it satisfies
   1. There is no cycle. 
   2. The graph is connected.
*/

public class IsATree {

    private int V;
    private List<Integer> adj[];

    @SuppressWarnings({"unchecked", "rawtypes"})
    public IsATree(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int vertex, int edge) {
        adj[vertex].add(edge);
    }

    boolean isTree() {
        // Mark all the vertices as not visited and not part of recursion stack
        boolean visited[] = new boolean[V];

        // The call to isCyclicUtil serves multiple purposes
        // It returns true if graph reachable from vertex 0 is cyclic.
        // It also marks all vertices reachable from 0.
        for (int source = 0; source < V; source++) {
             if (isCyclicUtil(source, visited, -1)) {
                 return false;
            }
        }

        // Checking if all vertex are being already visited at DFS traversal or not.
        // This represents connected/Unconnected vertex.
        for (int u = 0; u < V; u++) {
             if (!visited[u]) {
                 return false;
             }
        }

        return true;
    }

    boolean isCyclicUtil(int source, boolean visited[], int parent) {
        // Mark the current node as visited
        visited[source] = true;
        Integer neighbor;

        Iterator<Integer> it = adj[source].iterator();
        while (it.hasNext()) {
            neighbor = it.next();
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, source)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        IsATree g1 = new IsATree(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);

        if (g1.isTree()) {
            System.out.println("Graph is Tree");
        }
        else {
            System.out.println("Graph is not Tree");
        }

        IsATree g2 = new IsATree(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);

        if (g1.isTree()) {
            System.out.println("Graph is Tree");
        }
        else {
            System.out.println("Graph is not Tree");
        }
     }
}
