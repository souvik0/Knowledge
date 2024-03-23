package com.expression;

import java.util.*;

public class InfixToPostfix {

    public static void main(String[] args) {
        String infix = "a+b*c-(d/e+f)*g";
        String postfix = infixToPostfix(infix);
        System.out.println("Infix expression: " + infix);
        System.out.println("Postfix expression: " + postfix);
    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder(); // To build postFix expression
        Stack<Character> stack = new Stack<>(); // To keep track of operation

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Discard '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
}
