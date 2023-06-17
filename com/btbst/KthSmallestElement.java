package com.btbst;

import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestElement {

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        int k = 4;
        // find the k'th smallest node
        Node result = findKthSmallest(root, k);

        if (result != null) {
            System.out.printf("%d'th smallest node is %d", k, result.data);
        }
        else {
            System.out.printf("%d'th smallest node does not exist.", k);
        }
    }

    public static Node findKthSmallest(Node root, int k) {
        // Counter to keep track of the total number of the visited nodes.
        // `AtomicInteger` is used here since `Integer` is passed by value in Java
        AtomicInteger counter = new AtomicInteger(0);

        // Recursively find the k'th smallest node
        return kthSmallest(root, counter, k);
    }

    // Recursive function to find the k'th smallest node
    // in the BST (using in-order traversal)
    public static Node kthSmallest(Node root, AtomicInteger counter, int k) {
        // base case
        if (root == null) {
            return null;
        }

        // recur for the left subtree
        Node left = kthSmallest(root.left, counter, k);

        // if k'th smallest node is found
        if (left != null) {
            return left;
        }

        // if the root is k'th smallest node
        if (counter.incrementAndGet() == k) {
            return root;
        }

        // recur for the right subtree only if k'th smallest node is not found
        // in the right subtree
        return kthSmallest(root.right, counter, k);
    }
}
