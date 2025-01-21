package com.linkedlist;

public class DetectCycleNodeInLinkedList {

    public Node<Integer> head;

    public DetectCycleNodeInLinkedList() {
        this.head = null;
    }

    public static void main(String[] args) {
        DetectCycleNodeInLinkedList detectCycle = new DetectCycleNodeInLinkedList();
        detectCycle.insertAtAnyPosition(1, 1);
        detectCycle.insertAtAnyPosition(2, 2);
        detectCycle.insertAtAnyPosition(3, 4);
        detectCycle.insertAtAnyPosition(4, 5);
        detectCycle.head.next.next.next = detectCycle.head.next;
        System.out.println("Does the linked list have a cycle: " + detectCycle.detectCycle().data);
    }

    public Node<Integer> detectCycle() {
        if (head == null || head.next == null) {
            return null; // No cycle if there's no node or only one node.
        }

        Node<Integer> slow = head; // Starts at head.
        Node<Integer> fast = head; // Starts at head.

        while (fast != null && fast.next != null) {
            slow = slow.next; // Moves one step.
            fast = fast.next.next; // Moves two steps.

            if (slow == fast) {
                // There's a cycle, now find the entrance to the cycle.
                Node<Integer> start = head; // Start a new pointer at head.
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start; // The start of the cycle.
            }
        }

        return null;
    }

    public void inserAtFirst(int key) {
        Node<Integer> newNode = new Node<Integer>(key);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtAnyPosition(int position, int key) {
        Node<Integer> newNode = new Node<Integer>(key);

        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            inserAtFirst(key);
            return;
        }

        Node<Integer> current = head;
        int count = 1;

        while (count < position - 1 && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        // Reach the target position & perform insertion operation between current.next & newNode
        newNode.next = current.next;
        current.next = newNode;
    }
}
