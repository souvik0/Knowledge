package com.graph;
/* 
 * We do a BFS traversal of the given graph. 
 * For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited
 * and u is not a parent of v, then there is a cycle in the graph.
 * If we don’t find such an adjacent for any vertex, we say that there is no cycle.
 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleUndirectedGraphBFS {

    private int V;
    private List<Integer>[] adj;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public DetectCycleUndirectedGraphBFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int vertex, int edge) {
        adj[vertex].add(edge);
    }

    public static void main(String[] args) {
        DetectCycleUndirectedGraphBFS graph = new DetectCycleUndirectedGraphBFS(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        if (graph.isCyclicDisconntected()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public boolean isCyclicDisconntected() {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        for (int source = 0; source < V; source++) {
            if (!visited[source] && isCyclicConntected(source, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCyclicConntected(int source, boolean[] visited) {
        // Set parent vertex for every vertex as -1.
        int parent[] = new int[V];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
         // Mark the current node as visited and enqueue it
        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            int polledVertex = queue.poll();

            // Get all adjacent vertices of the dequeued vertex u.
            // If a adjacent has not been visited, then mark it visited and enqueue it.
            // We also mark parent so that parent is not considered for cycle.
            Iterator<Integer> itr = adj[polledVertex].listIterator();
            while (itr.hasNext()) {
                  int neighbor = itr.next();
                  if (!visited[neighbor]) {
                      visited[neighbor] = true;
                      queue.add(neighbor);
                      parent[neighbor] = polledVertex;
                  } else if (parent[polledVertex] != neighbor) {
                      return true;
                  }
            }
        }
        return false;
    }
}
