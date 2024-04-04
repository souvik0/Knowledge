package com.btbst;

public class ConstructBSTFromPostOrder {

    public static void main(String[] args) {
        int[] postorder = {1, 4, 3, 6, 8, 7, 5, 2};
        ConstructBSTFromPostOrder solution = new ConstructBSTFromPostOrder();
        TreeNode root = solution.constructBST(postorder);
        printInorder(root); // Output: 1 2 3 4 5 6 7 8
    }

    private static void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    private int findPartitionIndex(int[] postorder, int start, int end, int key) {
        int i;
        for (i = end; i >= start; i--) {
            if (postorder[i] < key) {
                break;
            }
        }
        return i + 1;
    }

    private TreeNode constructBST(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[end]);
        int partitionIndex = findPartitionIndex(postorder, start, end, root.data);

        root.left = constructBST(postorder, start, partitionIndex - 1);
        root.right = constructBST(postorder, partitionIndex, end - 1);

        return root;
    }

    public TreeNode constructBST(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }

        return constructBST(postorder, 0, postorder.length - 1);
    }
}
