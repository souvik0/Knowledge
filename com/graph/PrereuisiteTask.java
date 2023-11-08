package com.graph;

// This problem needs to be resolved applying DFS on directed graph
// This problem also caters 2d array to adjacencyList representation

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrereuisiteTask {

    public static void main(String[] args) {
        int numTasks = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}}; // Representing order of task
        boolean canFinish = canFinish(numTasks, prerequisites);
        System.out.println("Can finish all courses: " + canFinish);
    }

    public static boolean canFinish(int numTasks, int[][] prerequisites) {
        // Build adjacency list representation of the graph
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjacencyList.computeIfAbsent(prerequisiteCourse, k -> new ArrayList<>()).add(course);
        }

        // Array to keep track of visited nodes during DFS
        boolean[] visited = new boolean[numTasks];

        // Array to keep track of nodes in the current DFS path to detect cycles
        boolean[] inPath = new boolean[numTasks];

        // Perform DFS for each course
        for (int source = 0; source < numTasks; source++) {
            if (!visited[source] && hasCycle(source, adjacencyList, visited, inPath)) {
                return false; // Cycle detected, cannot finish all courses
            }
        }

        return true;
    }

    private static boolean hasCycle(int course, Map<Integer, List<Integer>> adjacencyList,
                                    boolean[] visited, boolean[] inPath) {
        if (inPath[course]) {
            return true; // Cycle detected
        }

        if (visited[course]) {
            return false; // Already visited, no cycle
        }

        visited[course] = true;
        inPath[course] = true;

       // DFS for neighbors
       if (adjacencyList.containsKey(course)) {
           for (int neighbor : adjacencyList.get(course)) {
                if (hasCycle(neighbor, adjacencyList, visited, inPath)) {
                    return true; // Cycle detected in the DFS
                }
           }
       }

       inPath[course] = false; // Backtrack
       return false;
    }
}
