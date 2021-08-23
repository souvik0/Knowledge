package dynamicprogramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

    public static class GrpahNode {
        int data;
        boolean visited;
        List<GrpahNode> neighbours;

        public GrpahNode(int data) {
            this.data = data;
            neighbours = new ArrayList<GrpahNode>();
        }

        public List<GrpahNode> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<GrpahNode> neighbours) {
            this.neighbours = neighbours;
        }

        public void addNeighbours(GrpahNode node) {
            this.neighbours.add(node);
        }
    }

    public void bfs(GrpahNode node) {
        // Queue required for BFS
        Queue<GrpahNode> queue = new LinkedList<GrpahNode>();
        queue.add(node);
        node.visited = true;

        while (!queue.isEmpty()) {
            GrpahNode polledElement = queue.poll();
            System.out.println(polledElement.data);

            List<GrpahNode> neighbourList = polledElement.getNeighbours();
            for (int i = 0 ; i < neighbourList.size(); i++) {
                GrpahNode n = neighbourList.get(i);
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;
                }
            }
        }
    }

    public void dfs(GrpahNode node) {
         // Stack required for DFS
        Stack<GrpahNode> stack = new Stack<GrpahNode>();
        stack.push(node);

        while (!stack.isEmpty()) {
            GrpahNode popedElement = stack.pop();
            if (!popedElement.visited) {
                System.out.println(popedElement.data);
                popedElement.visited = true;
            }
            List<GrpahNode> neighbourList = popedElement.getNeighbours();
            for (int i = 0 ; i < neighbourList.size(); i++) {
                GrpahNode n = neighbourList.get(i);
                if (n != null && !n.visited) {
                    stack.push(n);
                }
            }
        }
    }
}
