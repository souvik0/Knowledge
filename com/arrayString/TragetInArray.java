package com.arrayString;

import java.util.ArrayDeque;
import java.util.Deque;

class Pair {
    Integer num;
    Character sign;

    Pair(Integer num, Character sign) {
        this.num = num;
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "(" + this.sign + ")" + this.num + " ";
    }
}

public class TragetInArray {
    private static void printList(Deque<Pair> list) {
        for (Pair pair : list) {
            System.out.print(pair);
        }
        System.out.println();
    }

    // Print all ways to calculate a target from elements of specified array
    public static void printWays(int[] arr, int n, int sum, int target, Deque<Pair> list) {
        // base case: if target is found, print result list
        if (sum == target) {
            printList(list);
            return;
        }
        // base case: No elements are left
        if (n < 0) {
            return;
        }

        // Ignore the current element
        printWays(arr, n - 1, sum, target, list);

        // Consider the current element and subtract it from the target
        list.addLast(new Pair(arr[n], '+'));
        printWays(arr, n - 1, sum + arr[n], target, list);
        list.pollLast();	// backtracking

        // Consider the current element and add it to the target
        list.addLast(new Pair(arr[n], '-'));
        printWays(arr, n - 1, sum - arr[n], target, list);
        list.pollLast();	// backtracking
    }

    public static void main(String[] args) {
        // input array and target number
        int[] arr = { 5, 3, -6, 2 };
        int target = 6;
        printWays(arr, arr.length - 1, 0, target, new ArrayDeque<>());
    }
}