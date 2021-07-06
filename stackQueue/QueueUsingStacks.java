package com.stackQueue;

import java.util.Stack;

public class QueueUsingStacks {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    Stack<Integer> stack ;
    Stack<Integer> tmpStack ;

    public QueueUsingStacks () {
        stack = new Stack<Integer>();
        tmpStack = new Stack<Integer>();
    }

    /*  Function to insert an element to the queue */
    public void insert(int data) {
        /* if no element is present in stack s then
         * push the new element to stack s 
        */
        if (stack.size() == 0) {
            stack.push(data);
        }
        else {
            /* if elements are present in stack s then
             * pop all the elements from stack s and
             * push them to stack tmp  */
            int lengthOfStack = stack.size();
            for (int i = 0; i < lengthOfStack; i++) {
                tmpStack.push(stack.pop());
            }
            // push the new element to stack s * 
            stack.push(data);
            /* pop all elements from stack tmp and
             * push them to stack s */
            for (int i = 0; i < lengthOfStack; i++)
                stack.push(tmpStack.pop());
        }
    }

    /* Function to remove front element from the queue */
    public int remove() {
        if (stack.size() == 0) {
            System.out.println("No Elements");
        }
        return stack.pop();
    }
}