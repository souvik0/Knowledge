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
        System.out.println("Value of the " + n + "th node from the end: " + nthNode.data);
    }

    public static Node<Integer> findNthNodeFromLast(Node<Integer> head, int k) {
        if (head == null || n <= 0) {
            return null;
        }

        // Create two pointers, first and second
        Node<Integer> first = head;
        Node<Integer> second = head;

        // Move the second pointer k -1 steps ahead
        for (int i = 0; i < k; i++) {
            if (second == null) {
                return null; // If n is greater than the length of the list
            }
            second = second.next;
        }

        // Move both pointers until the second pointer reaches the end
        while (second != null) {
            first = first.next;
            second = second.next;
        }

        // At this point, the first pointer is at the nth node from the end
        return first;
    }
}
