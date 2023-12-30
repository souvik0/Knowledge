package com.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    public static Node mergeKLists(Node[] lists) {
        // create an empty min-heap using a comparison object for ordering the min-heap
        PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingInt(a -> ((Node) a).data));

        // push the first node of each list into the min-heap
        pq.addAll(Arrays.asList(lists).subList(0, lists.length));

        // take two pointers, head and tail, where the head points to the first node
        // of the output list and tail points to its last node
        Node head = null, last = null;

        // run till min-heap is empty
        while (!pq.isEmpty()) {
            // extract the minimum node from the min-heap
            Node min = pq.poll();

            // add the minimum node to the output list
            if (head == null) {
                head = last = min;
            } else {
                last.next = min;
                last = min;
            }

            // take the next node from the "same" list and insert it into the min-heap
            if (min.next != null) {
                pq.add(min.next);
            }
        }

        // return head node of the merged list
        return head;
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
        int k = 3;// total number of linked lists

        // an array to store the head nodes of the linked lists
        Node[] lists = new Node[k];

        lists[0] = new Node(1);
        lists[0].next = new Node(5);
        lists[0].next.next = new Node(7);

        lists[1] = new Node(2);
        lists[1].next = new Node(3);
        lists[1].next.next = new Node(6);
        lists[1].next.next.next = new Node(9);

        lists[2] = new Node(4);
        lists[2].next = new Node(8);
        lists[2].next.next = new Node(10);

        // Merge all lists into one
        Node head = mergeKLists(lists);
        printList(head);
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
