package com.btbst;

import java.util.Stack;

public class SpiralOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        spiralOrderTraversal(root);
    }

    public static void spiralOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode popedNode = stack1.pop();
                System.out.print(popedNode.data + " ");

                if (popedNode.left != null) {
                    stack2.push(popedNode.left);
                }

                if (popedNode.right != null) {
                    stack2.push(popedNode.right);
                }
            }

            while (!stack2.isEmpty()) {
                TreeNode popedNode = stack2.pop();
                System.out.print(popedNode.data + " ");

                if (popedNode.right != null) {
                    stack1.push(popedNode.right);
                }

                if (popedNode.left != null) {
                    stack1.push(popedNode.left);
                }
            }
        }
    }
}
