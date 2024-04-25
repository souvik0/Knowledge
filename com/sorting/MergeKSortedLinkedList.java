package com.sorting;

import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    public static Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>(lists.length, (a, b) -> a.data - b.data);

        // Insert the first node of each list into the priority queue
        for (Node node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        while (!minHeap.isEmpty()) {
            // Extract the smallest node from the heap
            Node minNode = minHeap.poll();
            // Move the tail and point it to the current smallest node
            tail.next = minNode;
            tail = minNode;

            // If there is a next node in the list, push it into the queue
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
        }

        return dummy.next;
    }

    // Utility function to print contents of a linked list
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " —> ");
            node = node.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        // Test the function with an example
        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(5);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        Node list3 = new Node(2);
        list3.next = new Node(6);

        Node[] lists = new Node[] {list1, list2, list3};
        Node mergedList = mergeKLists(lists);
        printList(mergedList);
    }
}

//A Linked List Node
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
