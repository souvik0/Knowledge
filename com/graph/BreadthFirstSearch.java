package com.graph;
// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//This class represents a directed graph using adjacency list representation
public class BreadthFirstSearch {

    private int V; // No. of vertices
    private List<Integer>[] adj; // Adjacency Lists represents neighbour of a vertices

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public BreadthFirstSearch(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
             adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int edge) {
        adj[v].add(edge);
    }

    // prints BFS traversal from a given source s
    public void bfs(int s) {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> itr = adj[s].listIterator();
            while (itr.hasNext()) {
                  int n = itr.next();
                  if (!visited[n]) {
                      visited[n] = true;
                      queue.add(n);
                  }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch graph = new BreadthFirstSearch(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
        graph.bfs(2);
    }
}

/* Complexity Analysis: 
Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
Space Complexity: O(V), since an extra visited array of size V is required.
*/
