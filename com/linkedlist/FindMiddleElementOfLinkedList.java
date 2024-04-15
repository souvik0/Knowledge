package com.linkedlist;

public class FindMiddleElementOfLinkedList {

    public Node<Integer> start;

    public FindMiddleElementOfLinkedList() {
        this.start = null;
    }

    public static void main(String[] args) {
        FindMiddleElementOfLinkedList middleElemt = new FindMiddleElementOfLinkedList();
        middleElemt.insertAtAnyPosition(1, 1);
        middleElemt.insertAtAnyPosition(2, 2);
        middleElemt.insertAtAnyPosition(3, 4);
        middleElemt.insertAtAnyPosition(4, 5);
        System.out.println("Middle element is: " + middleElemt.findMiddleElement());
        middleElemt.insertAtAnyPosition(5, 10);
        middleElemt.insertAtAnyPosition(6, 9);
        System.out.println("Middle element is: " + middleElemt.findMiddleElement());
    }

    public int findMiddleElement() {
        Node<Integer> slow = start;
        Node<Integer> fast = start;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
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
