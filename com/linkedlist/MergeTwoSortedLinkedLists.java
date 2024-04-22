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

    public static Node<Integer> mergeTwoLists(Node<Integer> head1, Node<Integer> head2) {
         if (head1 == null) {
             return head2;
         }

         if (head2 == null) {
             return head1;
         }

         if (head1.data < head2.data) {
             head1.next = mergeTwoLists(head1.next, head2);
             return head1;
         } else {
             head2.next = mergeTwoLists(head1, head2.next);
             return head2;
         }
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
