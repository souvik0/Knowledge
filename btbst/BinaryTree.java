package com.btbst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    int deepestLevel;
    int value;

    // Pointing head of doubly Linked List
    private TreeNode head = null;
    static TreeNode previous = null;
    /**
     * All recursive approach used implicit stack
    */
    /* This pre order traversal is also DFS (Depth First Search */
    public void preOrderRecursiveTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            preOrderRecursiveTraversal(root.left);
            preOrderRecursiveTraversal(root.right);
        }
    }

    public void inOrderRecursiveTraversal(TreeNode root) {
        if (root != null) {
            inOrderRecursiveTraversal(root.left);
            System.out.println(root.data);
            inOrderRecursiveTraversal(root.right);
        }
    }

    public void postOrderRecursiveTraversal(TreeNode root) {
        if (root != null) {
            postOrderRecursiveTraversal(root.left);
            postOrderRecursiveTraversal(root.right);
            System.out.println(root.data);
        }
    }

    /**
     * All iterative approach used explicit stack. 
     * right child should get into stack prior to left as stack is of LIFO nature
     * This algorithm also used for reverse level order traversal.
     * Reverse level order traversal with stack
     */
    public void preOrderIterativeTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode popedNode = stack.pop();
            System.out.println(popedNode.data);

            if (popedNode.right != null) {
                stack.push(popedNode.right);
            }
            if (popedNode.left != null) {
                stack.push(popedNode.left);
            }
        }
    }

    // Order to print left -> root -> right
    public void inOrderIterativeTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            /* Reach the left most Node of the current Node 
               It is going to left most part of every node including root node
            */
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.println(current.data);
            current = current.right;
        }
    }

    /* Level Order traversal used Queue as inherent data structure
       This level oder traversal is same as BFS
    */
    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode popedNode = queue.poll();
            System.out.println(popedNode.data);

            if (popedNode.left != null) {
                queue.add(popedNode.left);
            }
            if (popedNode.right != null) {
                queue.add(popedNode.right);
            }
        }
    }

    /**
     * spiral order traversal is level order traversal in special with double stack empty along with populating
     * temporary stack
     */
    public void spiralOrZigzagTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Stack<TreeNode> tempStack = new Stack<TreeNode>();
            /* with root element this loop will be traversed only once. Then onwards based on size of tempstack */
            while (!stack.isEmpty()) {
                TreeNode tempNode = stack.pop();
                System.out.println(tempNode.data);

                boolean directionFlag = true;

                if (!directionFlag) {
                    if (tempNode.left != null) {
                        tempStack.push(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        tempStack.push(tempNode.right);
                    }
                } else {
                    if (tempNode.right != null) {
                        tempStack.push(tempNode.right);
                    }
                    if (tempNode.left != null) {
                        tempStack.push(tempNode.left);
                    }
                }
                // reverse the direction in every traversal
                directionFlag = !directionFlag;
            }
            stack = tempStack;
        }
    }

    public void boundaryOrderTraversal(TreeNode root) {
        // Yet to come
    }

    /**
     * level order traversal with max variable
    */
    public int findMaxElement(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode popedNode = queue.poll();

            if (max < popedNode.data) {
                max = popedNode.data;
            }
            if (popedNode.left != null) {
                queue.add(popedNode.left);
            }
            if (popedNode.right != null) {
                queue.add(popedNode.right);
            }
        }

        return max;
    }

    /**
     * level order traversal  or reverse level order traversal with size variable
     * It means number of nodes a tree is containing
    */
    public int sizeOfTree(TreeNode root) {
        int size = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            size++;

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }

        return size;
    }

    // level will be 0 while invoking to denote root level
    public void printAllPathsFromRootToLeaf(TreeNode root, int[] path, int level) {
        if (root == null) {
            return;
        }
        path[level] = root.data;
        // root is the only node in tree & that is the lead node
        if (root.left == null && root.right == null) {
            printArrayUtil(path);
        }
        printAllPathsFromRootToLeaf(root.left, path, level + 1);
        printAllPathsFromRootToLeaf(root.right, path, level + 1);
    }

    public static void  printArrayUtil(int[] path) {
        for (int i = 0; i < path.length; i++) {
            System.out.print(" "+ path[i]);
        }
        System.out.println();
    }

    public int countOfLeafNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countOfLeafNodes(root.left) +
               countOfLeafNodes(root.right);
    }

    /*
    * level argument will remain 0 for all invocation
    * key is data associated with the node / identification of node of whose level needs to be find out
    * This is similar to search a node in Binary tree
    */
    public int levelOfNode(TreeNode root, int nodeData, int level) {
        if (root == null) {
            return -1;
        }
        if (root.data == nodeData) {
            return level;
        } else {
            level++;
        }
        // Looking at left subtree
        int left = levelOfNode(root.left, nodeData, level);
        // If left nodes doesn't exist
        if (left == -1) {
            return levelOfNode(root.right, nodeData, level);
        }
        return left;
    }

    // diameter/ width is nothing but longest distance between two edge nodes of tree
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Considering diameter passes through the root
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        // Considering diameter when not passes through the root
        int lDiameter = diameterOfBinaryTree(root.left);
        int rDiameter = diameterOfBinaryTree(root.right);

        return Math.max(1 + lHeight + rHeight, Math.max(lDiameter, rDiameter));
    }

    // Measure both subtree height & return the max
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return 1 + Math.max(lHeight, rHeight);
    }

    // Find out common ancestor node or common root node  Here we need to find out lowest common 
    // ancestor between node 'a' & 'b'
    public TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        // If one of them is root, then root is the lca node
        if (root.data == a.data || root.data == b.data) {
            return root;
        }

        TreeNode left = lca(root.left, a, b);
        TreeNode right = lca(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
           return right;
        } else if (right == null) {
           return left;
        }
        return null;
    }

    public int distanceBetweenTwoNodes(TreeNode root, TreeNode a, TreeNode b) {
        // Calculate common root node between two nodes using lca
        TreeNode lcaNode = lca(root, a, b);
        // Calculating respective level of a node from lca node
        int d1 = levelOfNode(lcaNode, a.data, 0);
       // Calculating respective level of b node from lca node
        int d2 = levelOfNode(lcaNode, b.data, 0);

        return d1 + d2;
    }

    public int findDistanceFromRootToNode(TreeNode root, TreeNode a) {
        if (root == null) {
            return 0;
        }

        int distance = -1;
        // Check if x is present at root or in left  
        // subtree or right subtree.
        if ((root.data == a.data) ||
           (distance = findDistanceFromRootToNode(root.left, a)) >= 0 ||
           (distance = findDistanceFromRootToNode(root.right, a)) >= 0) {
                return 1 + distance;
        }

        return distance;
    }

    // To find out maximum valued node at up to given level
    public int maxNodeAtGivenLevel(TreeNode root, int level) {
        if (root == null) {
            return -1;
        }
        // At 0th level root is the maximum node
        if (level == 0) {
            return root.data;
        }
        // Traversing left subtree
        int left = maxNodeAtGivenLevel(root.left, level-1);
        // Traversing right subtree
        int right = maxNodeAtGivenLevel(root.right, level-1);

        return Math.max(left, right);
    }

    /*
     * level order traversal with level_no & nodeCount variable  
     * This algorithm is going found out which level has maximum number of node
     */
    public int maxNodeCountAtLevel(TreeNode root) {
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int currentLevel = 0;
        int level_no = 0;

        // Maximum node at same level. Checker variable to set new level
        int maxNodeCount = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            // Giving nodeCount of each level
            int nodeCount = queue.size();
            if (nodeCount > maxNodeCount) {
                maxNodeCount = nodeCount;
                level_no = currentLevel;
            }
            currentLevel++;

            // Level order traversal up to for current level to get the node count
            while (nodeCount > 0) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                nodeCount--;
            }
        }
        return level_no;
    }

    // Returning level having maximum sum
    public int findMaximumLevelSum(TreeNode root) {
        int currentSum;
        int maxSum = Integer.MIN_VALUE;
        int currentLevel = 0;
        int level_no = 0;

        if (root == null) {
            System.out.println("Tree is empty");
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // For every level initialize currentSum to 0 to get currentSum of each level.
            currentSum = 0;
            int nodeCount = queue.size();
            // Level order traversal up to nodecount in every level
            while (nodeCount > 0) {
                TreeNode tempNode = queue.poll();
                currentSum = currentSum + tempNode.data;

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    level_no = currentLevel;
                }
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                nodeCount--;
            }
            currentLevel++;
        }
        return level_no;
    }

    // Using in order traversal.
    /* 1. go to the left sub tree
     * 2. Process the node in doubly linked list 
     * 3. go the right sub tree*/
    public TreeNode convertBTtoDoublyLinkedList(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Reach left subtree
        convertBTtoDoublyLinkedList(root.left);

        // Process individual node
        if (previous == null) {
            head = root;
        } else {
            root.left = previous;
            previous.right = root;
        }

        // Reach right subtree
        convertBTtoDoublyLinkedList(root.right);
        // previous is the head of the doubly linked list now
        return previous;
    }

    public boolean isMirrorTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
           return false;
        }
        return isMirrorTree(root1.left, root2.right) &&
               isMirrorTree(root1.right, root2.left);
    }

    public boolean isIdenticalTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return isIdenticalTree(root1.left, root2.left) &&
               isIdenticalTree(root1.right, root2.right);
    }

    // Combination of identical & mirror tree condition
    public boolean isIsomorphic(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        // Same Isomorphic(Identical tree) & cross Isomorphic(Cross Isomorphic)
        if (root1.data == root2.data) {
            if ((isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)) ||
                (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left))) {
                 return true;
            }
        }
        return false;
    }

    // Same algorithm to find depth of the tree
    public int findDeepestLevelAndNode(TreeNode root) {
        findDeepestLevel(root, 0);
        System.out.println("Deepest level: " + deepestLevel);
        System.out.println("Value of deepest node: " + value);
        return value;
    }

    public void findDeepestLevel(TreeNode root, int level) {
        if (root != null) {
            findDeepestLevel(root.left, level++);

            if (level > deepestLevel) {
                deepestLevel = level - 1;
                value = root.data;
            }

            findDeepestLevel(root.right, level);
        }
    }

    public int findDeepestLeftNode(TreeNode root) {
        findDeepestLeftLevel(root, 0, true);
        System.out.println("Deepest level: " + deepestLevel);
        System.out.println("Deepest Left Node: " + value);
        return value;
    }

    public void findDeepestLeftLevel(TreeNode root, int level, boolean left) {
        if (root != null) {
            findDeepestLeftLevel(root.left, level++, left);

            if (left && level > deepestLevel) {
                deepestLevel = level - 1;
                value = root.data;
            }

            findDeepestLeftLevel(root.right, level, false);
        }
    }
}
