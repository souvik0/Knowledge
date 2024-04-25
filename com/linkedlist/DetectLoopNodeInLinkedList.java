package com.linkedlist;

public class DetectLoopNodeInLinkedList {

    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(3);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(0);
        Node<Integer> node4 = new Node<Integer>(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle

        Node<Integer> cycleNode = detectCycle(head);
        if (cycleNode != null) {
            System.out.println("Cycle begins at node with value: " + cycleNode.data);
        } else {
            System.out.println("No cycle detected.");
        }
    }

    public static Node<Integer> detectCycle(Node<Integer> head) {
        if (head == null || head.next == null) {
            return null; // No cycle if there's no node or only one node
        }

        Node<Integer> slow = head; // This will move one step at a time
        Node<Integer> fast = head; // This will move two steps at a time
        boolean hasCycle = false;

        // Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // Cycle detected
                hasCycle = true;
                break;
            }
        }

        // Find the node where the cycle begins
        if (hasCycle) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        return null; // No cycle
    }
}
