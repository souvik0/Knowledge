package com.linkedlist;

public class RemoveElementFromSortedLinkedList {

    public static void main(String[] args) {
        // Create a sorted linked list
        Node<Integer> head = new Node<Integer>(1);
        head.next = new Node<Integer>(2);
        head.next.next = new Node<Integer>(2);
        head.next.next.next = new Node<Integer>(3);
        head.next.next.next.next = new Node<Integer>(3);
        head.next.next.next.next.next = new Node<Integer>(4);

        System.out.println("Original List:");
        printList(head);

        // Remove all instances of '2'
        head = removeElements(head, 2);
    }

    public static void printList(Node<Integer> node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static Node<Integer> removeElements(Node<Integer> head, int data) {
        // Handle initial cases where the head needs to be removed
        while (head != null && head.data == data) {
            head = head.next;
        }

        // Check if the list became empty
        if (head == null) return null;

        // Remove nodes from the rest of the list
        Node<Integer> current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next; // Skip the node to remove
            } else {
                current = current.next; // Move to the next node
            }
        }

        System.out.println("Modified List after removing '2':");
        printList(head);

        return head;
    }
}
