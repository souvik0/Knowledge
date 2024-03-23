package com.expression;

import java.util.*;

public class InfixToPrefix {

    public static void main(String[] args) {
        String infix = "(a+b*c-(d/e+f)*g)";
        String prefix = infixToPrefix(infix);
        System.out.println("Infix expression: " + infix);
        System.out.println("Prefix expression: " + prefix);
    }

    public static String infixToPrefix(String infix) {
        // Reverse the infix expression and swap '(' with ')' and vice versa
        infix = reverseInfix(infix);

        StringBuilder prefix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                prefix.append(c);
            } else if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.append(stack.pop());
                }
                stack.pop(); // Discard ')'
            } else {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                    prefix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }

        return prefix.reverse().toString();
    }

    private static String reverseInfix(String infix) {
        StringBuilder reversed = new StringBuilder();
        for (char c : infix.toCharArray()) {
            if (c == '(') {
                reversed.append(')');
            } else if (c == ')') {
                reversed.append('(');
            } else {
                reversed.append(c);
            }
        }
        return reversed.reverse().toString();
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
