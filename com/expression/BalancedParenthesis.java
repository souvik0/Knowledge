package com.expression;

import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String[] args) {
        String expression = "(141[])(){waga}((51afaw))()hh()";
        String expression2 = "10()";
        String expression3 = "{{}}()[()]";
        System.out.println(balancedParenthesis(expression));
        System.out.println(balancedParenthesis(expression2));
        System.out.println(balancedParenthesis(expression3));
    }

    public static boolean balancedParenthesis(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {
             char ch = expression.charAt(i);
             if (ch == '(' || ch == '{' || ch == '[') {
                 stack.push(ch);
             } else {
                 if (stack.isEmpty() && isClosingParenthesis(ch)) {
                     return false;
                 }
                 if ((ch == ')' && stack.peek() == '(') ||
                     (ch == '}' && stack.peek() == '{') ||
                     (ch == ']' && stack.peek() == '[')) {
                        stack.pop();
                 }
             }
        }
        // If stack is empty that means expression is valid one
        return stack.isEmpty();
    }

    public static boolean isClosingParenthesis(char x) {
        switch(x) {
            case ')':
            case '}':
            case ']':
                return true;
        } 
    return false;
    }
}