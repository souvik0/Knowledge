package com.recursion;

// Involvement of all 3 numbers are required.
//Time Complexity : O(4^n)

import java.util.List;
import java.util.ArrayList;

public class EvaluateExpression {

    public static void main(String[] args) {
        String inputExp = "234";
        int target = 24;
        List<String> res = getExprssion(inputExp, target);
        printResult(res);

        inputExp = "125";
        target = 7;
        res = getExprssion(inputExp, target);
        printResult(res);
    }

    // Below method returns all possible expression evaluating to target
    public static List<String> getExprssion(String inputExp, int target) {
        List<String> resultList = new ArrayList<String>();
        getExpressionUtil(resultList, "", inputExp, target, 0, 0, 0);
        return resultList;
    }

    // Utility recursive method to generate all possible expressions
    public static void getExpressionUtil(List<String> resultList,
                                         String curExp, String inputExp,
                                         int target, int start, int curVal, int last) {
        // true if whole input is processed with some operators
        if (start == inputExp.length()) {
            // if current value is equal to target then only add to final solution
            // if question is : all possible o/p then just push_back without condition
            if (curVal == target) {
                resultList.add(curExp);
            }
            return;
        }

        // loop to put operator at all positions
        for (int i = start; i < inputExp.length(); i++) {
            // take part of input from pos to i
            String part = inputExp.substring(start, i + 1);

            // take numeric value of part
            int cur = Integer.parseInt(part);

            // if start is 0 then just send numeric value for next recursion
            if (start == 0) {
                getExpressionUtil(resultList, curExp + part, inputExp, target, i + 1, cur, cur);
            }
            // try all given binary operator for evaluation
            else {
                getExpressionUtil(resultList, curExp + "+" + part, inputExp, target, i + 1,
                                  curVal + cur, cur);
                getExpressionUtil(resultList, curExp + "-" + part, inputExp, target, i + 1,
                                  curVal - cur, cur);
                getExpressionUtil(resultList, curExp + "*" + part, inputExp, target, i + 1,
                                  curVal * cur, cur);
                getExpressionUtil(resultList, curExp + "/" + part, inputExp, target, i + 1,
                                  curVal / cur, cur);
            }
        }
    }

    // method to print result
    public static void printResult(List<String> res) {
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " | ");
        }
        System.out.println();
    }
}
