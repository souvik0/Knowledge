package com.linkedlist;

public class KthNodeFromLast {

    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(1);
        head.next = new Node<Integer>(2);
        head.next.next = new Node<Integer>(3);
        head.next.next.next = new Node<Integer>(4);
        head.next.next.next.next = new Node<Integer>(5);

        int n = 2; // Position of the node to find from the end

        Node<Integer> nthNode = findNthNodeFromLast(head, n);
        System.out.println("Value of the " + n + "nd node from the end: " + nthNode.data);
    }

    public static Node<Integer> findNthNodeFromLast(Node<Integer> head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        // Create two pointers, first and second
        Node<Integer> firstPointer = head;
        Node<Integer> secondPointer = head;
        int counter = 0;

        while (secondPointer != null && counter++ < k) {
            secondPointer = secondPointer.next;
        }

        // Move both pointers until the second pointer reaches the end
        while (secondPointer != null) {
            secondPointer = secondPointer.next;
            firstPointer = firstPointer.next;
        }

        // At this point, the first pointer is at the nth node from the end
        return firstPointer;
    }
}
