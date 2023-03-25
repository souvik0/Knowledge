package com.recursion;

public class FindNthFibonaci {

    public static void main(String[] args) {
        int n = 2;
        System.out.println("F(n) = " + fibo(n));
    }

    public static int fibo(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }

        return fibo(num - 1) + fibo(num - 2);
    }
}
