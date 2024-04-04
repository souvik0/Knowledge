package com.btbst;

import java.util.Stack;

public class ConstructBSTFromPreorder {

    public static void main(String[] args) {
        ConstructBSTFromPreorder tree = new ConstructBSTFromPreorder();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        TreeNode root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }

    public TreeNode constructTree(int pre[], int size) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // The first element of pre[] is always root
        TreeNode root = new TreeNode(pre[0]);
        // Push root
        stack.push(root);

        // Iterate through rest of the size-1 items of given pre-order array
        for (int i = 1; i < size; ++i) {
            TreeNode temp = null;

            //Keep on popping while the next value is greater than stack's top value
            while (!stack.isEmpty() && pre[i] > stack.peek().data) {
                temp = stack.pop();
            }

            // Make this greater value as the right child and push it to the stack
            if (temp != null) {
                temp.right = new TreeNode(pre[i]);
                stack.push(temp.right);
            } else {
                temp = stack.peek();
                temp.left = new TreeNode(pre[i]);
                stack.push(temp.left);
            }
        }

        return root;
    }

    // A utility function to print in-order traversal of a Binary Tree
    public void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
