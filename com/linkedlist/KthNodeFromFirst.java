package com.linkedlist;

public class KthNodeFromFirst {

    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(1);
        head.next = new Node<Integer>(2);
        head.next.next = new Node<Integer>(3);
        head.next.next.next = new Node<Integer>(4);
        head.next.next.next.next = new Node<Integer>(5);

        int n = 3; // Position of the node to find

        Node<Integer> nthNode = findNthNodeFromFirst(head, n);
        System.out.println("Value of the " + n + "th node from the beginning: " + nthNode.data);
    }

    public static Node<Integer> findNthNodeFromFirst(Node<Integer> head, int k) {
        int count = 0;
        Node<Integer> current = head;

        while (current != null && count < k -1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return null; // If n is greater than the length of the list
        }

        return current;
    }
}
