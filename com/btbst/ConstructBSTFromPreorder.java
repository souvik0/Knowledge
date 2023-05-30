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
        Stack<TreeNode> s = new Stack<TreeNode>();
        // The first element of pre[] is always root
        TreeNode root = new TreeNode(pre[0]);
        // Push root
        s.push(root);

        // Iterate through rest of the size-1 items of given pre-order array
        for (int i = 1; i < size; ++i) {
            TreeNode temp = null;

            //Keep on popping while the next value is greater than stack's top value
            while (!s.isEmpty() && pre[i] > s.peek().data) {
                temp = s.pop();
            }

            // Make this greater value as the right child and push it to the stack
            if (temp != null) {
                temp.right = new TreeNode(pre[i]);
                s.push(temp.right);
            }

            // If the next value is less than the stack's top value, make this value as 
            // the left child of the stack's top node. Push the new node to stack
            else {
                temp = s.peek();
                temp.left = new TreeNode(pre[i]);
                s.push(temp.left);
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
