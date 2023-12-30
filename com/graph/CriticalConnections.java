package com.graph;

import java.util.*;

public class CriticalConnections {

    private int time = 0;

    public static void main(String[] args) {
        CriticalConnections solution = new CriticalConnections();
        int n = 4;
        List<List<Integer>> connections = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 0),
                Arrays.asList(1, 3)
        );
        List<List<Integer>> result = solution.criticalConnections(n, connections);
        System.out.println(result);
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> connection : connections) {
            graph.computeIfAbsent(connection.get(0), k -> new ArrayList<>()).add(connection.get(1));
            graph.computeIfAbsent(connection.get(1), k -> new ArrayList<>()).add(connection.get(0));
        }

        int[] disc = new int[n]; // Discovery time
        int[] low = new int[n];  // Earliest visited vertex (reachable vertex with the smallest discovery time)

        List<List<Integer>> result = new ArrayList<>();
        dfs(0, -1, graph, disc, low, result);

        return result;
    }

    private void dfs(int u, int parent, Map<Integer, List<Integer>> graph, int[] disc, int[] low, List<List<Integer>> result) {
        disc[u] = low[u] = ++time;

        for (int v : graph.getOrDefault(u, Collections.emptyList())) {
            if (v == parent) continue; // Skip the edge to the parent

            if (disc[v] == 0) {
                dfs(v, u, graph, disc, low, result);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    result.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
