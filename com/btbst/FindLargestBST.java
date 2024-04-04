package com.btbst;

// To find out largest BST from binary tree

public class FindLargestBST {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right.left = new Node(9);
        root.right.right = new Node(20);

        int size = largestBST(root);
        System.out.println("Size of the largest BST in the binary tree: " + size);
    }

    public static Integer largestBST(Node root) {
        if (root == null) {
            return 0;
        }

        int lHeight = largestBST(root.left);
        int rHeight = largestBST(root.right);

        // Check if BST
        if (lHeight == -1 || rHeight == -1 ||
           (root.left != null && root.left.data > root.data) ||
           (root.right != null && root.right.data < root.data)) {
               return -1;
        }

        return Math.max(1 + lHeight + rHeight, Math.max(lHeight, rHeight));
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
}
