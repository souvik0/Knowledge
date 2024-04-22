package com.btbst;

public class DeleteNodeFromBST {

    public static void main(String[] args) {
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            // Case 1: Node to be deleted has no children or only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node to be deleted has two children
            root.data = findMinValue(root.right); // Find the in-order successor
            root.right = deleteNode(root.right, root.data); // Delete the in-order successor
        }

        return root;
    }

    private int findMinValue(TreeNode node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }
}
