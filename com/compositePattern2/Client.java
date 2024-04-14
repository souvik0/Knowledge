package com.compositePattern2;

public class Client {

    public static void main(String[] args) {
        //2*(1+7)
        /*
                          *
                        /   \
                      2      +
                            / \
                           1   7
         */
         ArithmeticExpression one = new Number(1);
         ArithmeticExpression seven = new Number(7);
         ArithmeticExpression subExpression = new Expression(one, seven, Operation.ADD);

         ArithmeticExpression two = new Number(2);
         ArithmeticExpression finalExpression = new Expression(two, subExpression, Operation.MULTIPLY);

         finalExpression.evaluate();
    }
}
