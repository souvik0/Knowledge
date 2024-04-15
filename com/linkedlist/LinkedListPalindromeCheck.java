package com.linkedlist;

public class LinkedListPalindromeCheck {

    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(1);
        head.next = new Node<Integer>(2);
        head.next.next = new Node<Integer>(3);
        head.next.next.next = new Node<Integer>(2);
        head.next.next.next.next = new Node<Integer>(1);

        System.out.println("Is the linked list a palindrome? " + isPalindrome(head));
    }

    public static boolean isPalindrome(Node<Integer> head) {
        if (head == null || head.next == null) {
            return true; // Empty list or single node is considered a palindrome
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        // Find the middle of the linked list
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        Node<Integer> secondHalfHead = reverse(slow.next);

        // Compare the first half with the reversed second half
        while (secondHalfHead != null) {
            if (head.data != secondHalfHead.data) {
                return false; // Not a palindrome
            }
            head = head.next;
            secondHalfHead = secondHalfHead.next;
        }

        return true; // Palindrome
    }

    // Method to reverse a linked list
    public static Node<Integer> reverse(Node<Integer> head) {
        Node<Integer> newHead = null;
        Node<Integer> current = head;

        while (current != null) {
            Node<Integer> next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }

        return newHead; // New head of the reversed list
    }
}
