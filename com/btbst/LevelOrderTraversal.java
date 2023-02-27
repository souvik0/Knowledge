package com.btbst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);

        ArrayList<ArrayList<Integer>> resultList = level_order_traversal(root);
        for (ArrayList<Integer> path : resultList) {
            for (int i : path) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> level_order_traversal(BinaryTreeNode root) {
        // create an empty map to store nodes between given levels
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();

        // traverse the tree and insert its nodes into the map
        // corresponding to their level
        preorder(root, 1, map);

        // iterate through the map and print all nodes between given levels
        for (int i = 1; i <= map.size(); i++) {
            finalList.add(map.get(i));
        }
        return finalList;
    }

    // Traverse the tree in a preorder fashion and store nodes in a map
    // corresponding to their level
    public static void preorder(BinaryTreeNode root, int level, Map<Integer, ArrayList<Integer>> map){
        // base case: empty tree
        if (root == null) {
            return;
        }

        // insert the current node and its level into the map
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.value);

        // recur for the left and right subtree by increasing the level by 1
        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }
}
