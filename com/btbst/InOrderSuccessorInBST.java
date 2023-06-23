package com.btbst;

public class InOrderSuccessorInBST {

    public static void main(String[] args) {
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

         /* Construct the following tree
                    15
                  /    \
                 /      \
                10       20
               /  \     /  \
              /    \   /    \
             8     12 16    25
         */

        TreeNode root = null;
        for (int key: keys) {
            root = insert(root, key);
        }

        // find inorder successor for each key
        for (int key: keys) {
            TreeNode prec = findSuccessor(root, null, key);
            if (prec != null) {
                 System.out.println("The successor of node " + key + " is " + prec.data);
            }
            else {
                 System.out.println("The successor doesn't exist for node " + key);
            }
        }
    }

    public static TreeNode insert(TreeNode root, int key) {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new TreeNode(key);
        }

        // if the given key is less than the root node, recur for the left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }

        // if the given key is more than the root node, recur for the right subtree
        else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // Helper function to find the maximum value node in a given BST
    public static TreeNode findMinimum(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Recursive function to find inorder predecessor for a given key in the BST
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
        // if the given key is more than the root node, recur for the right subtree
        else if (key > root.data){
            return findSuccessor(root.right, succ, key);
        }
        // if the given key is less than the root node, recur for the left subtree
        else {
            // update successor to the current node before recursing
            // in the right subtree
            succ = root;
            return findSuccessor(root.left, succ, key);
        }

        return succ;
    }
}
