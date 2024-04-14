package com.stackQueue;

// Here push & pop operation is taking place in O(1) time complexity
public class StackUsingLinkedList {

    private Node<Integer> start;

    public StackUsingLinkedList() {
        this.start = null;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.pop()); // Output: 2
        System.out.println(stack.pop()); // Output: 1
        System.out.println(stack.pop()); // Output: Stack is empty
    }

    // Pushing element at the starting of the linked list
    public void push(int data) {
        Node<Integer> newNode = new Node<Integer>(data);
        newNode.next = start;
        start = newNode;
    }

    // Poping element from the starting of the linked list
    public int pop() {
        if (start == null) {
            System.out.println("Stack is empty");
            return -1; // Or throw an exception
        }

        int poppedData = start.data;
        start = start.next;
        return poppedData;
    }
}

class Node<T> {
    public int data;
    public Node<T> next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
