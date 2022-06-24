package com.expression;

import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String[] args) {
        String expression = "(141[])(){waga}((51afaw))()hh()";
        System.out.println(balancedParenthesis(expression));
    }

    public static boolean balancedParenthesis(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {
             char ch = expression.charAt(i);
             if (ch == '(' || ch == '{' || ch == '[') {
                 stack.push(ch);
             } else {
                 if (stack.isEmpty() && isBracket(ch)) {
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

    public static boolean isBracket(char x) {
        switch(x) {
            case '(':
            case ')':
            case '{':
            case '}':
            case '[':
            case ']':
                return true;
        } 
    return false;
    }
}