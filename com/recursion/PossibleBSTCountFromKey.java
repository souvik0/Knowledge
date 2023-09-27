package com.recursion;

public class PossibleBSTCountFromKey {

    public static void main(String[] args) {
        System.out.println("Total BST: " + countBSTs(3));
    }

    public static int countBSTs(int n) {
        if (n <= 1) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            // Calculate the number of BSTs for the left subtree and right subtree
            int leftSubtrees = countBSTs(i);
            int rightSubtrees = countBSTs(n - i - 1);

            // Multiply the number of BSTs for left and right subtrees
            count += leftSubtrees * rightSubtrees;
        }

        return count;
    }
}
