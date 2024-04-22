package com.linkedlist;

public class InsertAtLinkedList {

    public Node<Integer> start;

    public InsertAtLinkedList() {
        this.start = null;
    }

    public static void main(String[] args) {
        InsertAtLinkedList list = new InsertAtLinkedList();
        list.insertAtAnyPosition(1, 1);
        list.insertAtAnyPosition(2, 2);
        list.insertAtAnyPosition(3, 3);
        list.printList();
        list.insertAtAnyPosition(4, 5);
        list.printList();
    }

    public void inserAtFirst(Node<Integer> newNode) {
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
            inserAtFirst(newNode);
            return;
        }

        Node<Integer> current = start;
        int count = 1; // Assign to 1st position

        // Traverse up to target position
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        // Reached end of list
        if (current == null) {
            System.out.println("Position beyond length of list.");
            return;
        }

        // Reach the target position & perform insertion operation between current.next & newNode
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to print the linked list
    public void printList() {
        Node<Integer> current = start;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
