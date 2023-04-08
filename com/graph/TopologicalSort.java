package com.graph;

// Always take place in DAG(Directed Acyclic Graph)
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    private int V;
    private List<Integer> adj[];

    @SuppressWarnings({"unchecked", "rawtypes"})
    public TopologicalSort(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int vertex, int edge) {
        adj[vertex].add(edge);
    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Following is a Topological " + "sort of the given graph");
        // Function Call
        graph.topologicalSort();
    }

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to store Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Print contents of stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    // A recursive function used by topologicalSort
    public void topologicalSortUtil(int source, boolean visited[], Stack<Integer> stack) {
        // Mark the current node as visited.
        visited[source] = true;

        // Recur for all the vertices adjacent
        // to this vertex
        Iterator<Integer> it = adj[source].iterator();
        while (it.hasNext()) {
            Integer neighbor = it.next();
            if (!visited[neighbor])
                topologicalSortUtil(neighbor, visited, stack);
        }

        // Push current vertex to stack which stores result at the time when there is no
        // neighbor of this vertex exist.
        stack.push(source);
    }
}
