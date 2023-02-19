package com.btbst;

public class PopulateSiblingPointers {

    public static void main(String[] args) {
    }

    public static SpecialBinaryTreeNode populate_sibling_pointers(SpecialBinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        SpecialBinaryTreeNode current = root;
        while (current.left != null) {
            SpecialBinaryTreeNode nextLevel = current.left;

            while (current != null) {
                current.left.next_right = current.right;
                if (current.next_right == null) {
                    current.right.next_right = null;
                } else {
                    current.right.next_right = current.next_right.left;
                }
                current = current.next_right;
            }

            current = nextLevel;
        }
        return root;
    }
}
