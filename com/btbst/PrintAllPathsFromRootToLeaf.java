package com.btbst;

import java.util.ArrayList;

public class PrintAllPathsFromRootToLeaf {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);

        root.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        ArrayList<ArrayList<Integer>> resultList = all_paths_of_a_binary_tree(root);
        for (ArrayList<Integer> path : resultList) {
            for (int i : path) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> all_paths_of_a_binary_tree(BinaryTreeNode root) {
       /*
         * creating 2-d list in which each element is a 1-d list having one unique path
         * from root to leaf
         */
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<ArrayList<Integer>>();
        /* if root is null then there is no further action require so return */
        if (root == null) {
            return ansList;
        }

        ArrayList<Integer> pathList = new ArrayList<Integer>();
        /*
         * arr is a list which will have one unique path from root to leaf at a time. arr
         * will be updated recursively
         */
        allPathsofTreeHelper(root, pathList, ansList);
        /*
         * after helper function call our ans list updated with paths so we will return ans
         * list
         */
        return ansList;
    }

    public static void allPathsofTreeHelper(BinaryTreeNode root, ArrayList<Integer> pathList,
                               ArrayList<ArrayList<Integer>> finalList) {
        if (root == null) {
            return;
        }
        pathList.add(root.value);

        if (root.left == null && root.right == null) {
            finalList.add(new ArrayList<Integer>(pathList));
            return;
        }

        allPathsofTreeHelper(root.left, new ArrayList<Integer>(pathList), finalList);
        allPathsofTreeHelper(root.right, new ArrayList<Integer>(pathList), finalList);
    }
}
