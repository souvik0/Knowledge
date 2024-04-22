package com.linkedlist;

public class ReverseLinkedListGroupOfK {

    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(1);
        head.next = new Node<Integer>(2);
        head.next.next = new Node<Integer>(3);
        head.next.next.next = new Node<Integer>(4);
        head.next.next.next.next = new Node<Integer>(5);

        Node<Integer> reversedHead = reverseKGroup(head, 2);

        while (reversedHead != null) {
            System.out.print(reversedHead.data + " ");
            reversedHead = reversedHead.next;
        }
    }

    public static Node<Integer> reverseKGroup(Node<Integer> head, int k) {
        Node<Integer> current = head;
        Node<Integer> nextNode = null;
        Node<Integer> prevNode = null;

        int counter = 0;

        // Reverse up to K position
        while (current != null && counter++ < k) {
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }

        // Recursive call to reverse continuously for next k position
        if (nextNode != null) {
            head.next = reverseKGroup(nextNode, k);
        }

        // prevNode becomes headNode after 1st group reversal
        return prevNode;
    }
}
