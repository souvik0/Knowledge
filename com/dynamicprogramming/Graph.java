package com.dynamicprogramming;
//Java program to print BFS traversal from a given source vertex. 
//BFS(int s) traverses vertices reachable from s.
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//This class represents a directed graph using adjacency list representation
public class Graph {

    private int V; // No. of vertices
    private List<Integer>[] adj; // Adjacency Lists represents neighbour of a vertices

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Graph(int v) {
        this.V = v;
        for (int i = 0; i < v; i++) {
             adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
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
            System.out.print(s+" ");

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

    public void dfs() {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }

    public void dfsUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
 
        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                dfsUtil(n, visited);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
        g.bfs(2);

        System.out.println("Following is Depth First Traversal");
        g.dfs();
    }
}

/* Complexity Analysis: 
Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
Space Complexity: O(V), since an extra visited array of size V is required.
*/
