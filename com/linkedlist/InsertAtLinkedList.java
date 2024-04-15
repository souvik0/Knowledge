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

        // Traverse up to target position
        while (count < position - 1 && current != null) {
            current = current.next;
            count++;
        }

        // Reached end of list
        if (current == null) {
            System.out.println("Invalid position.");
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
