package com.recursion;

public class PrintFibonacciSeries {

    public static void main(String[] args) {
        printFibonacciSeries(5);
    }

    public static void printFibonacciSeries(int number) {
        int first = 0;
        int second = 1;
        System.out.println(first + " ");

        if (number > 1) {
            System.out.println(second + " ");
        }

        for (int i = 2; i < number ; i++) {
            int next = first + second;
            System.out.println(next + " ");
            first = second;
            second = next;
        }
    }
}
