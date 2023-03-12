package com.graph;
/*
 * Step-1: Compute in-degree (number of incoming edges) for each of the vertex present
 *         in the graph and initialize the count of visited nodes as 0.
 * Step-2: Pick all the vertices with in-degree as 0 and add them into a queue
 *         (Enqueue operation)
 * Step-3: Remove a vertex from the queue (Dequeue operation) and then
 *         a. Increment count of visited nodes by 1.
 *         b. Decrease in-degree by 1 for all its neighboring nodes.
 *         c. If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
 * Step 4: Repeat Step 3 until the queue is empty.
 * Step 5: If count of visited nodes is not equal to the number of nodes in the graph
 *         has cycle, otherwise not.
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class DetectCycleDirectedGraphBFS {

    private int V;
    private List<Integer> adj[];

    @SuppressWarnings({"unchecked", "rawtypes"})
    public DetectCycleDirectedGraphBFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int vertex, int edge) {
        adj[vertex].add(edge);
    }

    public static void main(String[] args) {
        DetectCycleDirectedGraphBFS graph = new DetectCycleDirectedGraphBFS(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        if (graph.isCyclic()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public boolean isCyclic() {
        // Create a vector to store in-degrees of all vertices.
        // Initialize all in-degrees as 0.
        int[] in_degree = new int[this.V];
        Arrays.fill(in_degree, 0);

        // Traverse adjacency lists to fill in-degrees of vertices.
        // This step takes O(V+E) time
        for (int u = 0; u < V; u++) {
            for (int v : adj[u]) {
                in_degree[v]++;
            }
        }

        // Create an queue and enqueue all vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }

        // Initialize count of visited vertices
        int visitedCount = 0;

        // Create a vector to store result (A topological ordering of the vertices)
        Vector<Integer> top_order = new Vector<>();

        while (!queue.isEmpty()) {

            // Extract front of queue (or perform dequeue)
            // and add it to topological order
            int u = queue.poll();
            top_order.add(u);

            // Iterate through all its neighboring nodes of dequeued node u and 
            // decrease their in-degree by 1
            for (int itr : adj[u]) {
                if (--in_degree[itr] == 0) {
                    queue.add(itr);
                }
            }
            visitedCount++;
        }

        // Check if there was a cycle
        if (visitedCount != this.V) {
            return true;
        } else {
            return false;
        }
    }
}
