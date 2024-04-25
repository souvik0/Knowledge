package com.arrayString;

public class LeaderInArray {

    public static void main(String[] args) {
        // Test array
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println("Leaders in the array are:");
        findLeaders(arr);
    }

    public static void findLeaders(int[] array) {
        int maxFromRight = array[array.length - 1];

        // The rightmost element is always a leader
        System.out.print(maxFromRight + " ");

        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > maxFromRight) {
                maxFromRight = array[i];
                // Leaders
                System.out.print(maxFromRight + " ");
            }
        }
    }
}
