package com.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CountConnectedComponents {

    private int V;
    private List<Integer> adj[];
    List<List<Integer> > components = new ArrayList<>();

    @SuppressWarnings({"unchecked", "rawtypes"})
    public CountConnectedComponents(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int vertex, int edge) {
        adj[vertex].add(edge);
        adj[edge].add(vertex);
    }

    public static void main(String[] args) {
        CountConnectedComponents g = new CountConnectedComponents(6);
        g.addEdge(1, 5);
        g.addEdge(0, 2);
        g.addEdge(2, 4);
        g.countConnectedComponents();
        System.out.println("Number of Conneceted Components: " + g.connecetedComponents());
    }

    public void countConnectedComponents() {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            if (!visited[i]) {
                DFSUtil(i, visited, al);
                components.add(al);
            }
        }
    }

    public void DFSUtil(int source, boolean[] visited, ArrayList<Integer> al) {
        visited[source] = true;
        al.add(source);

        Iterator<Integer> it = adj[source].iterator();
        while (it.hasNext()) {
            int neighbor = it.next();
            if (!visited[neighbor])
                DFSUtil(neighbor, visited, al);
        }
    }

    public int connecetedComponents() {
        return components.size();
    }
}
