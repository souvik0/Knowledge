package com.btbst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Vector;

import com.linkedlist.SinglyLinkedListImpl;

public class BinarySearchTree {

    public static int countElementLargest = 0;
    public static int countElementSmallest = 0;

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

    // Minimum Height BST construction
    public TreeNode convertSortedArrayToBST(int[] arr, int start, int end) {
        int mid = (start + end)/2 ;
        TreeNode root = new TreeNode(arr[mid]);

        // Left will lies from start to mid -1
        TreeNode leftSubtree = convertSortedArrayToBST(arr, start, mid - 1);
        root.left = leftSubtree;

        // Right will lies from mid + 1 to end
        TreeNode rightSubtree = convertSortedArrayToBST(arr, mid + 1, end);
        root.right = rightSubtree;

        return root;
    }

    /*
     * Find out right subtree root index to determine the last value of left subtree
     * or first value from array for right subtree
     */
    public TreeNode reconstructBST(List<Integer> preOrderList) {
        if (preOrderList.size() == 0) {
            return null;
        }

        int rootNodeValue = preOrderList.get(0);
        TreeNode root = new TreeNode(rootNodeValue);

        // Assume it's a right skewed tree
        int rightSubtreeRoot = preOrderList.size();

        /* Starting point of rightSubtree will always have higher have higher value than
           ending point of left subtree.
           Applying the above value >= rightSubtreeRoot
        */
        for (int i = 1; i < preOrderList.size(); i++) {
             int value = preOrderList.get(i);
             if (value >= rightSubtreeRoot) {
                 rightSubtreeRoot = i; // determining index of right subtree
                 break;
             }
        }

        TreeNode leftSubtree = reconstructBST(preOrderList.subList(1, rightSubtreeRoot - 1));
        TreeNode rightSubtree = reconstructBST(preOrderList.subList(rightSubtreeRoot, preOrderList.size()));

        root.left = leftSubtree;
        root.right = rightSubtree;

        return root;
    }

    // Finding out middle node of LinkedList & then creates root of BST
    // This can be considered as inOrder list also.
    public BinaryTreeNode sorted_list_to_bst(LinkedListNode head) {
        if (head == null) {
            return null;
        }
        // Create dummy node & make it haed of linked list
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;

        // Finding out mid of LinkedList which supposed to be root of BST
        LinkedListNode pre = null;
        LinkedListNode slow = dummy;
        LinkedListNode fast = dummy;

        // Finding out middle node of a linked list
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Breaking the list in two halves
        pre.next = null;
        BinaryTreeNode root = new BinaryTreeNode(slow.value);
        // Left of mid supposed to be left subtree
        root.left = sorted_list_to_bst(dummy.next);
        // Right of mid supposed to be right subtree
        root.right = sorted_list_to_bst(slow.next);

        return root;
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
    * In vertical view, need to print all the nodes are present in one level
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

        verticalView(root.left, level--);
        verticalView(root.right, level++);

        verticalViewMap.entrySet().stream().forEach(System.out::println);
    }

    /*
    * In top view, need to print first node that encounter in level order traversal
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

               // if the level is already present, then don't add new treeNode
               if (topViewNMap.containsKey(lvl)) {
                   // do Nothing
               } else {
                   System.out.println(tempNode.data);
                   topViewNMap.put(lvl, tempNode);
               }

               // Here it is doing level order traversal
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
    public TreeNode deleteNode(TreeNode root, int nodeData) {
        if (root == null) {
            return null;
        }

        // Traversing in both left & right direction
        if (root.data > nodeData) {
            root.left = deleteNode(root.left, nodeData);
        } else if (root.data < nodeData) {
            root.right = deleteNode(root.right, nodeData);
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

    public void findClosestValueInBST(TreeNode root, int target) {
        // Assuming root.data is the closest
        findClosestValueInBST(root, target, root.data);
    }

    public int findClosestValueInBST(TreeNode root, int target, int closest) {
        if (root == null) {
            return -1;
        }

        if (Math.abs(target - closest) > Math.abs(target - root.data)) {
            closest = root.data;
        }
        if (root.data > target && root.left != null) {
            return findClosestValueInBST(root.left, target, closest);
        }
        if (root.data < target && root.right != null) {
            return findClosestValueInBST(root.right, target, closest);
        }

        return closest;
    }

    /* Convert Binary Search Tree to Doubly Circular Linked List */
    // Function to perform In-Order traversal of the
    // tree and store the nodes in a vector
    public void inorder(BinaryTreeNode root, Vector<Integer> v) {
        if (root == null) {
            return;
        }
        /* first recur on left child */
        inorder(root.left, v);
        /* append the data of node in vector */
        v.add(root.value);
        /* now recur on right child */
        inorder(root.right, v);
    }

    // Function to convert Binary Tree to Circular
    // Doubly Linked list using the vector which stores
    // In-Order traversal of the Binary Tree
    public BinaryTreeNode bTreeToCList(BinaryTreeNode root) {
        // Base cases
        if (root == null) {
            return null;
        }

        // Vector to be used for storing the nodes
        // of tree in In-order form
        Vector<Integer> v = new Vector<>();

        // Calling the In-Order traversal function
        inorder(root, v);

        // Create the head of the linked list pointing
        // to the root of the tree
        BinaryTreeNode head_ref = new BinaryTreeNode(v.get(0));

        // Create a current pointer to be used in traversal
        BinaryTreeNode curr = head_ref;

        // Traversing the nodes of the tree starting
        // from the second elements
        for (int i = 1; i < v.size(); i++) {

            // Create a temporary pointer
            // pointing to current
            BinaryTreeNode temp = curr;

            // Current's right points to the current
            // node in traversal
            curr.right = new BinaryTreeNode(v.get(i));

            // Current points to its right
            curr = curr.right;

            // Current's left points to temp
            curr.left = temp;
        }
        // Current's right points to head of the list
        curr.right = head_ref;

        // Head's left points to current
        head_ref.left = curr;

        // Return head of the list
        return head_ref;
    }
}
