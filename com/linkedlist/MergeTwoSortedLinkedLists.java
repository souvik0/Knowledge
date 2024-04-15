package com.linkedlist;

// Applying merge sort algorithm
public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        // Example lists
        Node<Integer> l1 = new Node<Integer>(1);
        l1.next = new Node<Integer>(3);
        l1.next.next = new Node<Integer>(5);

        Node<Integer> l2 = new Node<Integer>(2);
        l2.next = new Node<Integer>(4);
        l2.next.next = new Node<Integer>(6);

        Node<Integer> mergedList = mergeTwoLists(l1, l2);
        printList(mergedList); 
    }

    public static Node<Integer> mergeTwoLists(Node<Integer> start1, Node<Integer> start2) {
        Node<Integer> dummy = new Node<Integer>(0);
        Node<Integer> current = dummy;

        while (start1 != null && start2 != null) {
            if (start1.data < start2.data) {
                current.next = start1;
                start1 = start1.next;
            } else {
                current.next = start2;
                start2 = start2.next;
            }
            current = current.next;
        }

        // Append the remaining elements
        if (start1 != null) {
            current.next = start1;
        } else {
            current.next = start2;
        }

        return dummy.next; // Head of the merged list
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
