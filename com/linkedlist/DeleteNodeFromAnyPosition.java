package com.linkedlist;

public class DeleteNodeFromAnyPosition {

    public static void main(String[] args) {
        int position = 4;
        Node<Integer> head = new Node<Integer>(1);
        head.next = new Node<Integer>(2);
        head.next.next = new Node<Integer>(3);
        head.next.next.next = new Node<Integer>(4);
        head.next.next.next.next = new Node<Integer>(5);

        System.out.println("Original list:");
        printList(head);

        deleteNode(head, position); // Deleting the node at position 2 (0-indexed)
        if (position != 0) {
            System.out.println("List after deleting node at position 4:");
            printList(head);
        }
    }

    public static void deleteNode(Node<Integer> head, int position) {
        // If linked list is empty
        if (head == null) {
            return;
        }

        // If head needs to be removed
        if (position == 0) {
            head = head.next;
            System.out.println("List after deleting node at position 0:");
            printList(head);
            return;
        }

        // Store head node
        Node<Integer> current = head;
        int counter = 0;

        // Find previous node of the node to be deleted
        while (current != null && counter++ < position -1) {
            current = current.next;
        }

        // If position is more than number of nodes
        if (current == null || current.next == null) {
            return;
        }

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node<Integer> tempNode = current.next.next;

        // Unlink the deleted node from list
        current.next = tempNode;
    }

    public static void printList(Node<Integer> head) {
        Node<Integer> current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
}
