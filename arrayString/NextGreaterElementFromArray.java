package com.arrayString;

import java.util.Stack;

public class NextGreaterElementFromArray {

    public static void main(String[] args) {
        int[] input = {98, 23, 54, 12, 20, 7, 27};
        findNextGraeterElement(input);
    }

    public static void findNextGraeterElement(int[] arr) {
        Stack<Integer> tempStack = new Stack<Integer>();
        tempStack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
             while (!tempStack.isEmpty() && arr[i] > tempStack.peek()) {
                 System.out.println("Next greater element of " + tempStack.pop() + " : is :" + arr[i]);
             }
             tempStack.push(arr[i]);
        }

        while (!tempStack.isEmpty()) {
            System.out.println("Next greater element of " + tempStack.pop() + " : is :" + null);
        }
    }
}