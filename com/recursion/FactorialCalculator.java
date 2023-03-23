package com.recursion;

public class FactorialCalculator {

    public static void main(String[] args) {
        int num = 6;
        long factorial = factorial(num);
        System.out.println("Factorial of " + num + " = " + factorial);
    }

    public static long factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
}
