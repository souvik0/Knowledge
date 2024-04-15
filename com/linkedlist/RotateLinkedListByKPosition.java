package com.linkedlist;
// Rotate list in right direction

public class RotateLinkedListByKPosition {

    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(1);
        head.next = new Node<Integer>(2);
        head.next.next = new Node<Integer>(3);
        head.next.next.next = new Node<Integer>(4);
        head.next.next.next.next = new Node<Integer>(5);

        int k = 2;

        Node<Integer> rotatedList = rotateRight(head, k);
        printList(rotatedList);
    }

    // Return head of the rotated list
    public static Node<Integer> rotateRight(Node<Integer> head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int length = getLength(head);
        k %= length; // Calculate actual rotation value

        if (k == 0) {
            return head;
        }

        Node<Integer> newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        Node<Integer> newHead = newTail.next;
        newTail.next = null; // Break the list

        Node<Integer> temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;

        return newHead;
    }

    // Method to calculate the length of a linked list
    public static int getLength(Node<Integer> head) {
        int length = 0;
        Node<Integer> current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    // Method to print the linked list
    public static void printList(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
