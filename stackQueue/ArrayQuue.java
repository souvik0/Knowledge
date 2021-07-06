package com.stackQueue;

public class ArrayQuue<T> {

    public static void main(String[] args) {
    // TODO Auto-generated method stub
    }
    protected Object[] arr;
    protected int front, rear, size;

    public ArrayQuue(int n) {
        front = -1;
        rear = -1;
        size = 0;
        arr = new Object[n];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return front == 0 && rear == size -1;
    }

    public int getSize() {
        return size;
    }

    public Object peak() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        }
        return arr[front];
    }

    public void enQueue(Object data) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (front == -1 && rear == -1) {
             front = 0;
             rear = 0;
             arr[front] = data;
             size++;
        } else if (rear < size - 1) {
            arr[++rear] = data;
            size++;
        }
    }

    public Object deQueue() {
        Object element = 0;
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            // Only 1 element is present
            if (front == rear) {
                element = arr[front];
                front = -1;
                rear = -1;
                size--;
            } else {
                element = arr[front];
                front++ ;
                size--;
            } 
        }
        return element;
    }
}
