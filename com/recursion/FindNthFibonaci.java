package com.recursion;

public class FindNthFibonaci {

    public static void main(String[] args) {
        int n = 9;
        System.out.println("F(n) = " + fibo(n));
    }

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }
}
