package com.btbst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.linkedlist.SinglyLinkedListImpl;

public class BinarySearchTree {

    static int countElementLargest = 0;
    static int countElementSmallest = 0;

    public TreeNode maxElementInBST(TreeNode root) {
        // If no node present at right side, then root is maximum node
        if (root.right == null) {
            return root;
        } else {
            return maxElementInBST(root.right);
        }
    }

    public TreeNode minElementInBST(TreeNode root) {
        // If no node present at left side, then root is minimum node
        if (root.left == null) {
            return root;
        } else {
            return minElementInBST(root.left);
        }
    }

    public TreeNode convertSortedArrayToBST(int[] arr, int start, int end) {
        int mid = (start + end)/2 ;
        TreeNode root = new TreeNode(arr[mid]);

        // Left will lies from start to mid -1
        TreeNode left = convertSortedArrayToBST(arr, start, mid - 1);
        root.left = left;

        // Right will lies from mid + 1 to end
        TreeNode right = convertSortedArrayToBST(arr, mid + 1, end);
        root.right = right;

        return root;
    }

    /* In this method, we construct from leaves to root. 
     * LinkedList sorted in ascending order.
     * The idea is to insert nodes in BST in the same order as they appear in Linked List so 
     * that the tree can be constructed in O(n) time complexity. We first count the number 
     * of nodes in the given Linked List. Let the count be n. After counting nodes, 
     * we take left n/2 nodes and recursively construct the left subtree. 
     * After left subtree is constructed, we allocate memory for root and link the 
     * left subtree with root. Finally, we recursively construct the right subtree and link it with root. 
     * While constructing the BST, we also keep moving the list head pointer to next so that we have 
     * the appropriate pointer in each recursive call.
     * */
    public TreeNode convertSortedLinkedListToBST(int n) {
        SinglyLinkedListImpl<Integer> linkedList = constructSortedLinkedList();
        TreeNode left = convertSortedLinkedListToBST(n/2);
        TreeNode root = new TreeNode(linkedList.start.data);
        root.left = left;
        linkedList.start = linkedList.start.next;
        root.right = convertSortedLinkedListToBST(n - n/2 -1);
        return root;
    }

    public SinglyLinkedListImpl<Integer> constructSortedLinkedList() {
        SinglyLinkedListImpl<Integer> linkedList = new SinglyLinkedListImpl<Integer>();
        linkedList.insertAtLast(10);
        linkedList.insertAtLast(20);
        linkedList.insertAtLast(30);
        linkedList.insertAtLast(40);
        linkedList.insertAtLast(50);
        return linkedList;
    }

    public boolean concludeBSTFromBT(TreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return concludeBSTFromBTUtil(root, min, max);
    }

    public boolean concludeBSTFromBTUtil(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return concludeBSTFromBTUtil(root.left, min, root.data) &&
               concludeBSTFromBTUtil(root.right, root.data, max);
    }

    public boolean search(TreeNode root, TreeNode nodeToBeSearched) {
        if (root.data == nodeToBeSearched.data) {
            return true;
        }
        // Search node present at left side
        if (root.data > nodeToBeSearched.data) {
            return search(root.left, nodeToBeSearched);
        }
        // Search node present at left side
        if (root.data < nodeToBeSearched.data) {
            return search(root.right, nodeToBeSearched);
        }
        return false;
    }

    /**
    * In vertical view , need to print all the nodes are present in one level
    * Vertical view approach applicable for all kinds of tree
    * Vertical view problem applies very popular hashing mechanism
    */
    public void verticalView(TreeNode root, int level) {
        //Here key signifies level of Tree & ArrayList holds list of nodes present at that level
        Map<Integer, List<TreeNode>> verticalViewMap = new HashMap<Integer, List<TreeNode>>();

        if (root == null) {
            return;
        }

        // To add new node present at the same level
        if (verticalViewMap.containsKey(level)) {
            List<TreeNode> treeNodeList = verticalViewMap.get(level);
            treeNodeList.add(root);
            verticalViewMap.put(level, treeNodeList);
        } else {
            ArrayList<TreeNode> treeNodeList = new ArrayList<TreeNode>();
            treeNodeList.add(root);
            verticalViewMap.put(level, treeNodeList);
        }

        verticalView(root.left, level - 1);
        verticalView(root.right, level + 1);
    }

    /*
    * In top view,need to print first node that encounter in level order traversal
    * Top view approach applicable for all kinds of tree
    * unlike ArrayList<TreeNode> as value in map, we are taking only first node appear at each level
    * Level Order traversal with QueuePack object
    * Bottom view can be done with same algorithm using stack
    */
    public void topView(TreeNode root, int level) {
        // Here key stands for level & value stands for data from first node at level
        Map<Integer, TreeNode> topViewNMap = new TreeMap<Integer, TreeNode>();
        Queue<QueuePack> queue = new LinkedList<QueuePack>();

        if (root == null) {
           return;
        } else {
           queue.add(new QueuePack(level, root));
           while (!queue.isEmpty()) {
               QueuePack queuePack = queue.poll();
               int lvl = queuePack.level;
               TreeNode tempNode = queuePack.tNode;

               // if the level is already present , then don't add new treeNode
               if (topViewNMap.containsKey(lvl)) {
                   // do Nothing
               } else {
                   System.out.println(tempNode.data);
                   topViewNMap.put(lvl, tempNode);
               }

               if (tempNode.left != null) {
                   queue.add(new QueuePack(level - 1, tempNode.left));
               } else if (tempNode.right != null) {
                   queue.add(new QueuePack(level + 1, tempNode.right));
               }
           }
        }
    }

    public TreeNode insert(TreeNode root, TreeNode nodeToBeInserted) {
        if (root == null) {
            root = nodeToBeInserted;
        } else {
            if (root.data > nodeToBeInserted.data) {
                if (root.left == null) {
                    root.left = nodeToBeInserted;
                } else {
                    insert(root.left, nodeToBeInserted);
                }
            } else if (root.data < nodeToBeInserted.data) {
                if (root.right == null) {
                    root.right = nodeToBeInserted;
                } else {
                    insert(root.right, nodeToBeInserted);
                }
            }
        }
        return root;
    }

    // value stands for data of the node to be deleted
    public TreeNode deleteNode(TreeNode root, int data) {
        if (root == null)
            return null;
        // Traversing in both left & right direction
        if (root.data > data) {
            root.left = deleteNode(root.left, data);
        } else if (root.data < data) {
            root.right = deleteNode(root.right, data);
        } else {
            // if nodeToBeDeleted have both children Here finding out inOrder successor
            if (root.left != null && root.right != null) {
                // Finding minimum element from right
                TreeNode minNodeFromRight = minElementInBST(root.right);
                // Replacing current node with minimum node from right subtree
                root.data = minNodeFromRight.data;
                // Deleting minimum node from right now
                root.right = deleteNode(root.right, minNodeFromRight.data);
            }
            // if nodeToBeDeleted has only left child
            else if (root.left != null) {
                root = root.left;
            }
            // if nodeToBeDeleted has only right child
            else if (root.right != null) {
                root = root.right;
            }
            // if nodeToBeDeleted do not have child (Leaf node)
            else {
                root = null;
            }
        }
        return root;
    }

    public int distanceFromRoot(TreeNode root, TreeNode a) {
        if (root == null) {
            return -1;
        }
        if (root.data == a.data) {
            return 0;
        }
        // If the node exist at left or right side
        if (root.data > a.data) {
            return 1 + distanceFromRoot(root.left, a); // Adding 1 level every time
        } else if (root.data < a.data) {
            return 1 + distanceFromRoot(root.right, a);
        } else {
            return -1;
        }
    }

    public int distanceBetweenTwoNodes(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return -1;
        }
        // if one of the node is root
        if (root.data == a.data) {
            return distanceFromRoot(root, b);
        }
        // if one of the node is root
        if (root.data == b.data) {
            return distanceFromRoot(root, a);
        }
        // If both the nodes present at left side
        if (root.data > a.data && root.data > b.data) {
           return distanceBetweenTwoNodes(root.left, a, b);
        }
        // If both the nodes present at right side
        if (root.data < a.data && root.data < b.data) {
           return distanceBetweenTwoNodes(root.right, a, b);
        }
        // If both the nodes present at different sides
        if ((root.data > a.data && root.data < b.data) ||
            (root.data > b.data && root.data < a.data)) {
            return distanceFromRoot(root, a) +
                   distanceFromRoot(root, b);
        }
        return -1;
    }

    /* inOrder traversal starting from left of the tree
     * This will flattening the tree in ascending order
    */
    public TreeNode kthSmallestElementInBST(TreeNode root, int k) {
        // Flattening the tree using inOrder traversal
        if (root == null) {
            return null;
        }
        TreeNode left = kthSmallestElementInBST(root.left, k);
        if (left != null) {
            return left;
        }
        // If kth smallest element isn't present in left side
        countElementSmallest++;
        // root can be the kth element also
        if (countElementSmallest == k) {
            return root;
        }
        // look for right side
        return kthSmallestElementInBST(root.right, k);
    }

    /* inOrder traversal starting from right of the tree
     * This will flattening the tree in descending order
     */
    public TreeNode kthLargestElementInBST(TreeNode root, int k) {
        // Flattening the tree using inOrder traversal
        if (root == null) {
            return null;
        }
        TreeNode right = kthLargestElementInBST(root.right, k);
        if (right != null) {
            return right;
        }
        // If kth element isn't present in left side
        countElementLargest++;
        // root can be the kth element also
        if (countElementLargest == k) {
            return root;
        }
        // look for right side
        return kthLargestElementInBST(root.left, k);
    }
}
