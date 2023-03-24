package com.recursion;

//Time Complexity : O(4^n)

import java.util.ArrayList;

public class EvaluateExpression {

    public static void main(String[] args) {
        String input = "123";
        int target = 6;
        ArrayList<String> res = getExprssion(input, target);
        printResult(res);

        input = "125";
        target = 7;
        res = getExprssion(input, target);
        printResult(res);
    }

    // Below method returns all possible expression evaluating to target
    public static ArrayList<String> getExprssion(String input, int target) {
        ArrayList<String> resultList = new ArrayList<String>();
        getExpressionUtil(resultList, "", input, target, 0, 0, 0);
        return resultList;
    }

     // Utility recursive method to generate all possible
    // expressions
    public static void getExpressionUtil(ArrayList<String> resultList,
                                         String curExp, String input,
                                         int target, int start, int curVal, int last) {
        // true if whole input is processed with some operators
        if (start == input.length()) {
            // if current value is equal to target then only add to final solution
            // if question is : all possible o/p then just push_back without condition
            if (curVal == target) {
                resultList.add(curExp);
            }
            return;
        }

        // loop to put operator at all positions
        for (int i = start; i < input.length(); i++) {
            // ignoring case which start with 0 as they are useless for evaluation
            if (i != start && input.charAt(start) == '0') {
                break;
            }

            // take part of input from pos to i
            String part = input.substring(start, i + 1);

            // take numeric value of part
            int cur = Integer.parseInt(part);

            // if start is 0 then just send numeric value for next recursion
            if (start == 0) {
                getExpressionUtil(resultList, curExp + part, input, target, i + 1, cur, cur);
            }
            // try all given binary operator for evaluation
            else {
                getExpressionUtil(resultList, curExp + "+" + part, input, target, i + 1,
                                  curVal + cur, cur);
                getExpressionUtil(resultList, curExp + "-" + part, input, target, i + 1,
                                  curVal - cur, -cur);
                getExpressionUtil(resultList, curExp + "*" + part, input, target, i + 1,
                                  curVal - last + last * cur, last * cur);
            }
        }
    }

    // method to print result
    public static void printResult(ArrayList<String> res) {
        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
        System.out.println();
    }
}
