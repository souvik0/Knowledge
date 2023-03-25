package com.graph;

// This represents weighted undirected graph
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstTraversal {

    private int V; // No. of vertices

    /* This is adjacency List representation. This representation is actually stands as
       List<List<Integer>>.
       Actual structure looks like LinkedList<LinkedList<Integer>>
    */
    private List<Integer> adj[];

    @SuppressWarnings({"unchecked", "rawtypes"})
    public DepthFirstTraversal(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int vertex, int edge) {
        adj[vertex].add(edge); // Add w to v's list.
    }

    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    public void DFS(int source) {
        // Mark all the vertices as
        // not visited(set as false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(source, visited);
    }

    // A function used by DFS
    public void DFSUtil(int source, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[source] = true;
        System.out.print(source + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> itr = adj[source].listIterator();
        while (itr.hasNext()) {
            int neighbor = itr.next();
            if (!visited[neighbor])
                DFSUtil(neighbor, visited);
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

       System.out.println("Following is Depth First Traversal (starting from vertex 2)");

       // Function call
       g.DFS(2);
    }
}
