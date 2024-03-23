package com.expression;

import java.util.*;

public class PrefixToInfixAndPostfix {

    public static void main(String[] args) {
        String prefix = "*+AB-CD"; // Prefix expression
        String infix = prefixToInfix(prefix);
        String postfix = prefixToPostfix(prefix);

        System.out.println("Prefix expression: " + prefix);
        System.out.println("Infix expression: " + infix);
        System.out.println("Postfix expression: " + postfix);
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static String prefixToPostfix(String prefix) {
        Stack<String> stack = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);

            if (isOperator(ch)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String expression = operand1 + operand2 + ch;
                stack.push(expression);
            } else {
                stack.push(ch + "");
            }
        }

        return stack.pop();
    }

    public static String prefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);

            if (isOperator(ch)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String expression = "(" + operand1 + ch + operand2 + ")";
                stack.push(expression);
            } else {
                stack.push(ch + "");
            }
        }

        return stack.pop();
    }
}
