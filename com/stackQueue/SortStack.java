package com.stackQueue;

/* Ultimate result set will be in the tempStack.
   For ascending order popedElement > tempStack.peek().To reverse in tempStack.
   For descending order popedElement < tempStack.peek().To reverse in tempStack.
*/

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> input = new Stack<Integer>(); 
        input.push(34);
        input.push(3);
        input.push(31);
        input.push(98);
        input.push(92);
        input.push(23);

        // This is the temporary stack 
        Stack<Integer> sortedStack = sortStack(input);
        System.out.println("Sorted numbers are:");

        while (!sortedStack.empty()) { 
            System.out.print(sortedStack.pop() + " "); 
        }
    }

    // This function return the sorted stack 
    public static Stack<Integer> sortStack(Stack<Integer> inputStack) {
        Stack<Integer> sortedStack = new Stack<Integer>();
        while (!inputStack.isEmpty()) {
            // pop out the first element 
            int popedElement = inputStack.pop();
            // while temporary stack is not empty and
            // top of stack is greater than temp
            while (!sortedStack.isEmpty() && popedElement > sortedStack.peek()) {
                inputStack.push(sortedStack.pop());
            }
            sortedStack.push(popedElement);
        }
        return sortedStack;
    }
}
