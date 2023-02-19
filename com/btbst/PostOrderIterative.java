package com.btbst;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderIterative {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(100);
        root.left = new BinaryTreeNode(200);
        root.left.left = new BinaryTreeNode(400);
        root.left.right = new BinaryTreeNode(500);
        root.right = new BinaryTreeNode(300);
        System.out.println(postorder_traversal(root).toString());
    }

    public static ArrayList<Integer> postorder_traversal(BinaryTreeNode root) {
        ArrayList<Integer> postOrderList = new ArrayList<Integer>();

        Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
        // Check for empty tree
        if (root == null) {
            return postOrderList;
        }

        st.push(root);
        BinaryTreeNode prev = null;

        while (!st.isEmpty()) {
            BinaryTreeNode current = st.peek();

            /* go down the tree in search of a leaf an if so
            process it and pop stack otherwise move down */
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    st.push(current.left);
                } else if (current.right != null) {
                    st.push(current.right);
                } else {
                    st.pop();
                    postOrderList.add(current.value);
                }

                /* go up the tree from left node, if the
                child is right push it onto stack otherwise
                process parent and pop stack */
            } else if (current.left == prev) {
                if (current.right != null) {
                    st.push(current.right);
                } else {
                    st.pop();
                    postOrderList.add(current.value);
                }

                /* go up the tree from right node and after
                coming back from right node process parent
                and pop stack */
            }
            else if (current.right == prev) {
                st.pop();
                postOrderList.add(current.value);
            }

            prev = current;
        }

        return postOrderList;
    }
}
