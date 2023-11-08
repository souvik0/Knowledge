package com.arrayString;

public class ConcludeHappyNumber {

    public static void main(String[] args) {
        int number = 19; // Change this to check if another number is a happy number
        boolean isHappy = isHappy(number);

        if (isHappy) {
            System.out.println(number + " is a happy number.");
        } else {
            System.out.println(number + " is not a happy number.");
        }
    }

    public static boolean isHappy(int number) {
        // Use two pointers to detect a cycle
        int slowPointer = number;
        int fastPointer = number;

        do {
            slowPointer = digitSquareSum(slowPointer); // Move one step
            fastPointer = digitSquareSum(digitSquareSum(fastPointer)); // Move two steps
        } while (slowPointer != fastPointer); // Detect a cycle

        return slowPointer == 1; // If it reaches 1, it's a happy number
    }

    public static int digitSquareSum(int number) {
        int squareSum = 0;

        while (number > 0) {
            int digit = number % 10;
            squareSum += digit * digit;
            number /= 10;
        }

        return squareSum;
    }
}
