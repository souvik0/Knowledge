package com.expression;

import java.util.Stack;

/* Alternate algorithm can be prefix expression can be converted to expression tree & then
 * perform inOrder traversal to get infix expression 
*/
public class PrefixToInfixAndPostfix {

    public static boolean isOperator(char x) {
        switch(x) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
        }
    return false;
    }

    /*  Convert prefix to Infix expression
     *  Always needs to traverse from end to first
    */
    public static String convertToInfix(String prefixExpression) {
        Stack<String> tempStack = new Stack<>(); 
        // Length of expression  
        int expressionLength = prefixExpression.length(); 
        // Reading from right to left  
        for (int i = expressionLength - 1; i >= 0; i--) {
             if (isOperator(prefixExpression.charAt(i))) {
                String operand1 = tempStack.pop();
                String operand2 = tempStack.pop();
                // Concat the operands and operator  
                String result = "(" + operand1 + prefixExpression.charAt(i) + operand2 + ")";
                tempStack.push(result); 
            } else { 
                // To make character to string added additional space
                tempStack.push(prefixExpression.charAt(i) + "");
            }
        }
        // Top most element in stack is the final infix String
        return tempStack.pop();
    }

    public static String convertToPostfix(String prefixExpression) {
        Stack<String> tempStack = new Stack<>(); 
        // Length of expression  
        int expressionLength = prefixExpression.length(); 
        // Reading from right to left  
        for (int i = expressionLength - 1; i >= 0; i--) {
             if (isOperator(prefixExpression.charAt(i))) {
                String operand1 = tempStack.pop();
                String operand2 = tempStack.pop();
                // Concat the operands and operator  
                String result = operand1 + operand2 + prefixExpression.charAt(i);
                tempStack.push(result); 
            } else { 
                // To make character to string 
                tempStack.push(prefixExpression.charAt(i) + "");
            }
        }
        // Top most element in stack is the final infix String
        return tempStack.pop();
    }

    // Driver code 
    public static void main(String[] args) {
        String exp = "*-A/BC-/AKL"; 
        System.out.println("Infix : " + convertToInfix(exp));
        System.out.println("Postfix : " + convertToPostfix(exp));
    }
}