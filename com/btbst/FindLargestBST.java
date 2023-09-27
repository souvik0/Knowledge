package com.btbst;

// To find out largest BST from binary tree

public class FindLargestBST {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);

        root.left = new BinaryTreeNode(15);
        root.right = new BinaryTreeNode(8);

        root.left.left = new BinaryTreeNode(12);
        root.left.right = new BinaryTreeNode(20);

        root.right.left = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(2);

        System.out.println("The size of the largest BST is " + find_largest_bst(root));
    }

    public static Integer find_largest_bst(BinaryTreeNode root) {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }
        return Math.max(find_largest_bst(root.left), find_largest_bst(root.right));
    }

    // Recursive function to calculate the size of a given binary tree
    public static int size(BinaryTreeNode root) {
        // base case: empty tree has size 0
        if (root == null) {
            return 0;
        }

        // recursively calculate the size of the left and right subtrees and
        // return the sum of their sizes + 1 (for root node)
        return size(root.left) + 1 + size(root.right);
    }

    // Recursive function to determine if a given binary tree is a BST or not
    // by keeping a valid range (starting from [-INFINITY, INFINITY]) and
    // keep shrinking it down for each node as we go down recursively
    public static boolean isBST(BinaryTreeNode node, int min, int max) {
        // base case
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return true;
        }

        // if the node's value falls outside the valid range
        if (node.value < min || node.value > max) {
            return false;
        }

        // recursively check left and right subtrees with updated range
        return isBST(node.left, min, node.value) &&
               isBST(node.right, node.value, max);
    }
}
