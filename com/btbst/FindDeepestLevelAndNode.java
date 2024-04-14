package com.btbst;

public class FindDeepestLevelAndNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        Result result = findDeepestLevelAndNode(root);
        System.out.println("Deepest level of the binary tree: " + result.level);
        System.out.println("Node at the deepest level: " + result.node.data);
    }

    public static Result findDeepestLevelAndNode(TreeNode root) {
        if (root == null) {
            return new Result(0, null);
        }

        Result leftResult = findDeepestLevelAndNode(root.left);
        Result rightResult = findDeepestLevelAndNode(root.right);

        if (leftResult.level > rightResult.level) {
            return new Result(leftResult.level + 1, leftResult.node);
        } else if (rightResult.level > leftResult.level) {
            return new Result(rightResult.level + 1, rightResult.node);
        } else { // in case both right & left subtree has equal height
            return new Result(leftResult.level + 1, root);
        }
    }
}
