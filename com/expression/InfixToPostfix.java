package com.expression;

import java.util.Stack;

public class InfixToPostfix {

    static int precedence(char ch) {
        switch (ch) { 
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '^':
            return 3;
        }
        return -1;
    }

    // The main method that converts given infix expression 
    // to postfix expression.  
    public static String infixToPostfix(String exp) { 
        // initializing empty String for result 
        String result = new String("");
        // initializing empty stack 
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i); 

             // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(ch))
                result += ch; 

            // If the scanned character is an '(', push it to the stack.
            else if (ch == '(') 
                stack.push(ch); 

            // If the scanned character is an ')', pop and output from the stack 
            // until an '(' is encountered. 
            else if (ch == ')') { 
                while (!stack.isEmpty() && stack.peek() != '(') {
                     result += stack.pop(); 
                }
                stack.pop();
            }

            // For other operators
            else { 
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())){
                    result += stack.pop(); 
                }
                stack.push(ch);
            }
        }

        // pop all the operators from the stack 
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    // Driver method  
    public static void main(String[] args) { 
        String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
        System.out.println(infixToPostfix(exp)); 
    } 
}