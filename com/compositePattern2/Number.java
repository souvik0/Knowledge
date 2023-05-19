package com.compositePattern2;

public class Number implements ArithmeticExpression{

    public int value;

    public Number(int value) {
        this.value = value;
    }

    public int evaluate(){
        System.out.println("Number value is :" + value);
        return value;
    }
}
