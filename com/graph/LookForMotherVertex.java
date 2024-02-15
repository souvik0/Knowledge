package com.graph;

// Time Complexity: O(V * (E+V))
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LookForMotherVertex {

    private int V; // No. of vertices

    /* This is adjacency List representation. This representation is actually stands as
       List<List<Integer>>.
       Actual structure looks like LinkedList<LinkedList<Integer>>
    */
    private List<Integer> adj[];

    @SuppressWarnings({"unchecked", "rawtypes"})
    public LookForMotherVertex(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int vertex, int edge) {
        adj[vertex].add(edge); // Add w to v's list.
    }

    public List<Integer> motherVertexList() {
        List<Integer> motherVertexList = new ArrayList<Integer>();
        boolean[] visited = new boolean[V];
        int v = -1; // This will hold potential mother vertex

        for (int i = 0 ; i < V; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                v = i; // Figuring out potential mother vertex
            }
        

        /* If there exist mother vertex (or vertices) in the given graph, then v must be one
           (or one of them).

           Now check if v is actually a mother vertex (or graph has a mother vertex).
           We basically check if every vertex is reachable from v or not. Here will apply
           DFS once again.

           Reset all values in visited[] as false and do DFS beginning from v to check
           if all vertices are reachable from it or not.
        */

            boolean[] check = new boolean[V];
            DFSUtil(v, check);
            /* If all the vertices are being visited from this vertex, then all elements must be
             * true in check[]. If anyone of them is false, that means the vertex isn't 
             * the mother vertex.
             */
            for (boolean val : check) {
                if (!val) {
                    // Do nothing
                } else {
                    if (!motherVertexList.contains(v)) {
                        motherVertexList.add(v);
                    }
                }
            }
        }

        return motherVertexList;
    }

    public void DFSUtil(int source, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[source] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> itr = adj[source].listIterator();
        while (itr.hasNext()) {
            int neighbour = itr.next();
            if (!visited[neighbour])
                DFSUtil(neighbour, visited);
        }
    }

    public static void main(String[] args) {
        LookForMotherVertex g = new LookForMotherVertex(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);

        System.out.println("A mother vertex is " + g.motherVertexList().toString());
    }
}
