package com.btbst;

public class InOrderSuccessorAndPredecessor {

    public static void main(String[] args) {
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
        /* Construct the following tree
                   15
                 /    \
                /      \
               10       20
              / \      /  \
             /   \    /    \
            8    12  16    25 */

        TreeNode root = null;
        for (int key: keys) {
            root = insert(root, key);
        }

        // find inorder successor for each key
        for (int key: keys) {
            TreeNode succ = findSuccessor(root, null, key);
            if (succ != null) {
                System.out.println("The successor of node " + key + " is " + succ.data);
            }
            else {
                System.out.println("No Successor exists for node " + key);
            }
        }

        for (int key: keys) {
            TreeNode prec = findPredecessor(root, null, key);
            if (prec != null) {
                System.out.println("The predecessor of node " + key + " is " + prec.data);
            }
            else {
                System.out.println("The predecessor doesn't exist for node " + key);
            }
        }
    }

    // Recursive function to insert a key into a BST
    public static TreeNode insert(TreeNode root, int key) {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new TreeNode(key);
        }
        // if the given key is less than the root node, recur for the left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    // Helper function to find minimum value node in a given BST
    public static TreeNode findMinimum(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Helper function to find the maximum value node in a given BST
    public static TreeNode findMaximum(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    // Recursive function to find an inorder successor for the given key in the BST
    public static TreeNode findSuccessor(TreeNode root, TreeNode succ, int key) {
        // base case
        if (root == null) {
            return succ;
        }

        // if a node with the desired value is found, the successor is the minimum
        // value node in its right subtree (if any)
        if (root.data == key) {
            if (root.right != null) {
                return findMinimum(root.right);
            }
        }

        // if the given key is less than the root node, recur for the left subtree
        else if (key < root.data) {
            // update successor to the current node before recursing in the left subtree
            succ = root;
            return findSuccessor(root.left, succ, key);
        } else {
            return findSuccessor(root.right, succ, key);
        }

        return succ;
    }

    // Recursive function to find inorder predecessor for a given key in the BST
    public static TreeNode findPredecessor(TreeNode root, TreeNode prec, int key) {
        // base case
        if (root == null) {
            return prec;
        }

        // if a node with the desired value is found, the predecessor is the maximum
        // value node in its left subtree (if any)
        if (root.data == key) {
            if (root.left != null) {
                return findMaximum(root.left);
            }
        }

        // if the given key is less than the root node, recur for the left subtree
        else if (key < root.data) {
            return findPredecessor(root.left, prec, key);
        }

        // if the given key is more than the root node, recur for the right subtree
        else {
            // update predecessor to the current node before recursing
            // in the right subtree
            prec = root;
            return findPredecessor(root.right, prec, key);
        }
        return prec;
    }
}
