package com.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQuees {

    public static void main(String[] args) {
        StackUsingQuees stackUsingQueue = new StackUsingQuees();
        stackUsingQueue.push(1);
        stackUsingQueue.push(2);
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.pop());
    }

    Queue<Integer> queue;
    Queue<Integer> tempQueue;
    int size;

    public StackUsingQuees () {
        size = 0;
        queue = new LinkedList<Integer>();
        tempQueue = new LinkedList<Integer>();
    }

    public void push(int element) {
        if (queue.isEmpty()) {
            queue.add(element);
        }
        else {
            /* if elements are present in q then
             * dequeue all the elements to 
             * temporary queue tmp */
            int lengthOfQueue = queue.size();
            for (int i = 0; i < lengthOfQueue; i++) {
                tempQueue.add(queue.poll());
            }
            /* Adding 2nd element onwards in the queue */
            queue.add(element);
            /* dequeue all the elements from
             * temporary queue tmp to q */
            for (int i = 0; i < lengthOfQueue; i++) {
                queue.add(tempQueue.poll());
            }
        }
        size ++;
    }

    public int pop() {
        if (queue.isEmpty()) {
            System.out.println("No elements in queue");
        }
        size--;
        return queue.poll();
    }
}