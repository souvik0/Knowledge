package com.btbst;

// This is same problem as invert binary tree.

public class ConstructMirrorTree {

    public static void main(String[] args) {
    }

    public static void mirror_image(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        swapLeftAndRightNode(root);
        mirror_image(root.left);
        mirror_image(root.right);
    }

    public static void swapLeftAndRightNode(BinaryTreeNode root) {
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
