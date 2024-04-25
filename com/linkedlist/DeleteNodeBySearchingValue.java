package com.linkedlist;

public class DeleteNodeBySearchingValue {

    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(1);
        head.next = new Node<Integer>(2);
        head.next.next = new Node<Integer>(3);
        head.next.next.next = new Node<Integer>(4);
        head.next.next.next.next = new Node<Integer>(5);

        deleteNode(head, 3);
    }

    public static void deleteNode(Node<Integer> head, int data) {
         Node<Integer> current = head;
         Node<Integer> prev = null;

         while (current != null && current.data != data) {
             prev = current;
             current = current.next;
         }

         // nothing to be deleted
         if (current == null) {
             return;
         }

         // delete either from 1st or any position
         if (prev == null) {
             head = head.next;
         } else {
             prev.next = current.next;
         }

         // Print the modified list
         printList(head);
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
