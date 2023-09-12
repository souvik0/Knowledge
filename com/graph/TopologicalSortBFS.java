package com.graph;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class TopologicalSortBFS {

    private int vertices;
    private List<Integer>[] adjacencyList;

    public TopologicalSortBFS(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to) {
        adjacencyList[from].add(to);
    }

    public List<Integer> topologicalSort() {
        int[] inDegrees = new int[vertices];

        // Calculate in-degrees for all vertices
        for (int i = 0; i < vertices; i++) {
            for (Integer neighbor : adjacencyList[i]) {
                inDegrees[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // Add vertices with in-degree 0 to the queue
        for (int i = 0; i < vertices; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);

            // Reduce in-degree of adjacent vertices
            for (Integer neighbor : adjacencyList[vertex]) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (result.size() != vertices) {
            // Graph has a cycle, so topological sorting is not possible
            return new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args) {
        // Create a sample graph
        TopologicalSortBFS graph = new TopologicalSortBFS(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        List<Integer> topologicalOrder = graph.topologicalSort();
        if (topologicalOrder.isEmpty()) {
            System.out.println("Topological sorting is not possible (Graph contains a cycle).");
        } else {
            System.out.println("Topological Sort Order: " + topologicalOrder);
        }
    }
}
