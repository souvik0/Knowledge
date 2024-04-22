package com.linkedlist;

public class DeleteNodeBySearchingValue {

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node<Integer> head = new Node<Integer>(1);
        head.next = new Node<Integer>(2);
        head.next.next = new Node<Integer>(3);
        head.next.next.next = new Node<Integer>(4);
        head.next.next.next.next = new Node<Integer>(5);

        // Delete node with value 3
        deleteNode(head, 1);
    }

    public static void deleteNode(Node<Integer> head, int data) {
         Node<Integer> temp = head;
         Node<Integer> prev = null;

         while (temp != null && temp.data != data) {
             prev = temp;
             temp = temp.next;
         }

         if (temp == null) {
             return;
         }

         if (prev == null) {
             head = head.next;
         } else {
             prev.next = temp.next;
         }

         temp = null;

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
