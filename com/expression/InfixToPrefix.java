package com.expression;

import java.util.Stack;

public class InfixToPrefix {

    public static boolean isOperator(char c) {
        return (!(c >= 'a' && c <= 'z') &&  
               !(c >= '0' && c <= '9') &&  
               !(c >= 'A' && c <= 'Z')); 
    }

    // Function to find priority  
    // of given operator. 
    public static int precedence(char ch) {
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

    // Function that converts infix 
    // expression to prefix expression. 
    public static String infixToPrefix(String infix) { 
        // stack for operators. 
        Stack<Character> operators = new Stack<Character>(); 

        // stack for operands. 
        Stack<String> operands = new Stack<String>(); 

        for (int i = 0; i < infix.length(); i++) {
            // If current character is an 
            // opening bracket, then 
            // push into the operators stack. 
            if (infix.charAt(i) == '(') { 
               operators.push(infix.charAt(i)); 
            }

            // If current character is a 
            // closing bracket, then pop from 
            // both stacks and push result 
            // in operands stack until 
            // matching opening bracket is 
            // not found. 
            else if (infix.charAt(i) == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    // operand 1 
                    String operand1 = operands.peek(); 
                    operands.pop(); 
                    // operand 2 
                    String operand2 = operands.peek(); 
                    operands.pop();
                    // operator 
                    char operator = operators.peek(); 
                    operators.pop();
                    // Add operands and operator 
                    // in form operator + 
                    // operand1 + operand2. 
                    String tmp = operator + operand1 + operand2; 
                    operands.push(tmp); 
                } 

                // Pop opening bracket from stack. 
                operators.pop(); 
            }

            // If current character is an operand then push it into operands stack. 
            else if (!isOperator(infix.charAt(i))) {
                operands.push(infix.charAt(i) + ""); 
            }

            // If current character is an 
            // operator, then push it into 
            // operators stack after popping 
            // high priority operators from 
            // operators stack and pushing 
            // result in operands stack. 
            else {
                while (!operators.isEmpty() && 
                       precedence(infix.charAt(i)) <= precedence(operators.peek())) { 
                    String operand1 = operands.peek(); 
                    operands.pop(); 

                    String operand2 = operands.peek(); 
                    operands.pop(); 

                    char operator = operators.peek(); 
                    operators.pop();

                    String tmp = operator + operand1 + operand2; 
                    operands.push(tmp); 
                } 

                operators.push(infix.charAt(i)); 
            } 
        } 

        // Pop operators from operators  
        // stack until it is empty and  
        // operation in add result of  
        // each pop operands stack. 
        while (!operators.empty()) { 
            String operand1 = operands.peek(); 
            operands.pop();

            String operand2 = operands.peek(); 
            operands.pop();

            char operator = operators.peek(); 
            operators.pop();

            String tmp = operator + operand2 + operand1; 
            operands.push(tmp); 
        }
        // Final prefix expression is 
        // present in operands stack. 
        return operands.pop(); 
    } 

    // Driver code 
    public static void main(String args[]) 
    { 
        String s = "(A-B/C)*(A/K-L)"; 
        System.out.println( infixToPrefix(s)); 
    } 
}