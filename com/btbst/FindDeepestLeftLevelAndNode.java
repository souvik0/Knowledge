package com.btbst;

import java.util.*;

public class FindDeepestLeftLevelAndNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        Result result = findDeepestLeftNode(root);
        System.out.println("Deepest left level of the binary tree: " + result.level);
        System.out.println("Leftmost node at the deepest left level: " + result.node.data);
    }

    public static Result findDeepestLeftNode(TreeNode root) {
        if (root == null) {
            return new Result(0, null);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode leftmostNode = null;
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            leftmostNode = null; // initialize to null at every level

            for (int i = 0; i < nodeCount; i++) {
                TreeNode polledNode = queue.poll();

                if (i == 0) {
                    leftmostNode = polledNode;
                }

                if (polledNode.left != null) {
                    queue.offer(polledNode.left);
                }

                if (polledNode.right != null) {
                    queue.offer(polledNode.right);
                }
            }

            currentLevel++;
        }

        return new Result(currentLevel - 1, leftmostNode);
    }
}
