package com.linkedlist;

public class DetectCycleInLinkedList {

    public Node<Integer> start;

    public DetectCycleInLinkedList() {
        this.start = null;
    }

    public static void main(String[] args) {
        DetectCycleInLinkedList detectCycle = new DetectCycleInLinkedList();
        detectCycle.insertAtAnyPosition(1, 1);
        detectCycle.insertAtAnyPosition(2, 2);
        detectCycle.insertAtAnyPosition(3, 4);
        detectCycle.insertAtAnyPosition(4, 5);
        detectCycle.start.next.next.next = detectCycle.start.next;

        System.out.println("Does the linked list have a cycle: " + detectCycle.hasCycle());
    }

    // Method to detect cycle in the linked list
    public boolean hasCycle() {
        if (start == null || start.next == null) {
            return false;
        }

        Node<Integer> slow = start;
        Node<Integer> fast = start;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast pointers meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches the end of the list, there is no cycle
        return false;
    }

    public void inserAtFirst(int key) {
        Node<Integer> newNode = new Node<Integer>(key);
        newNode.next = start;
        start = newNode;
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

        Node<Integer> current = start;
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
