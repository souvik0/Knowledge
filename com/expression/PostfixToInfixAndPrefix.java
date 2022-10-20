package com.expression;

import java.util.Stack;

/* Java program for expression tree
   Postfix & prefix expressions are very easy to convert to expression tree
*/
class PostfixToInfixAndPrefix {

     // A utility function to check if 'c' 
     // is an operator 

    public boolean isOperator(char ch) { 
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') { 
           return true; 
        } 
        return false; 
    } 

     // Utility function to do inorder traversal to convert to infix expression
     public void inorder(TreeNode root) { 
         if (root != null) { 
             inorder(root.left); 
             System.out.print(root.data + " "); 
             inorder(root.right); 
         }
     }
     // Utility function to do preorder traversal to convert to prefix expression
     public void preOrder(TreeNode root) { 
         if (root != null) { 
             System.out.print(root.data + " ");
             preOrder(root.left);
             preOrder(root.right);
         }
     }

     // Returns root of constructed tree for given postfix expression 
     public TreeNode constructExpressionTree(char[] postfixExpression) {
         Stack<TreeNode> st = new Stack<TreeNode>(); 
         TreeNode root, left, right; 

        // Traverse through every character of input expression 
        for (int i = 0; i < postfixExpression.length; i++) {

             // If operand, simply push into stack 
             if (isOperator(postfixExpression[i])) {
                 root = new TreeNode(postfixExpression[i]);

                 // Pop two top nodes 
                 // Store top 
                 left = st.pop();
                 right = st.pop();

                 //  make them children 
                 root.right = right; 
                 root.left = left; 

                 // Add this subexpression to stack 
                 st.push(root);
             } else {
                 root = new TreeNode(postfixExpression[i]);
                 st.push(root); 
             }
     }

     // only element will be root of expression tree
     return st.pop();
}

    public static void main(String args[]) {

        PostfixToInfixAndPrefix expressionTree = new PostfixToInfixAndPrefix();
        String postfix = "ab+ef*g*-"; 
        char[] charArray = postfix.toCharArray(); 
        TreeNode root = expressionTree.constructExpressionTree(charArray);
        System.out.println("infix expression is: ");
        expressionTree.inorder(root);
        System.out.println("");
        System.out.println("Prefix expression is: ");
        expressionTree.preOrder(root);
    }
} 