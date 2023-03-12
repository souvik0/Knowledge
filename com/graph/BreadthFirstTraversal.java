package com.graph;
/* Java program to print BFS traversal from a given source vertex.
   BFS(int s) traverses vertices reachable from s.
   This represents weighted undirected graph
   Important point to note that Level order traversal in tree is BFS.
*/
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//This class represents a directed graph using adjacency list representation
public class BreadthFirstTraversal {

    private int V; // No. of vertices
    // This is adjacency List representation. This representation is actually stands as
    // List<LinkedList<Integer>>
    private List<Integer>[] adj;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public BreadthFirstTraversal(int v) {
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

    // prints BFS traversal from a given source s
    public void bfs(int source) {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            int polledVertex = queue.poll();
            System.out.print(polledVertex + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> itr = adj[polledVertex].listIterator();
            while (itr.hasNext()) {
                  int neighbor = itr.next();
                  if (!visited[neighbor]) {
                      visited[neighbor] = true;
                      queue.add(neighbor);
                  }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstTraversal graph = new BreadthFirstTraversal(4);
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
Space Complexity: O(V + E), since an extra visited array of size V is required.
*/
