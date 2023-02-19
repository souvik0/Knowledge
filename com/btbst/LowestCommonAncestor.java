package com.btbst;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.left = new BinaryTreeNode(8);
        root.left.right.right = new BinaryTreeNode(9);
        root.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        System.out.println("Lowest common ancestor: " + lca(root, root.left.right.left, root.right.left));
    }

    public static Integer lca(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
        BinaryTreeNode lcaNode = lcaNode(root, a, b);
        return lcaNode.value;
    }

    public static BinaryTreeNode lcaNode(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
        if (root == null) {
            return null;
        }

        if (root.value == a.value || root.value == b.value) {
            return root;
        }

        BinaryTreeNode left = lcaNode(root.left, a, b);
        BinaryTreeNode right = lcaNode(root.right, a, b);

        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}
