package com.arrayString;

/* Time Complexity : O(n*d)
    Space Complexity : O(1)
*/
public class LeftRotation {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        leftRotate(arr, d);
        for (int i = 0 ; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void leftRotate(int[] arr, int d) {
        for (int i = 0; i < d; i++) {
             leftRotateUtil(arr);
        }
    }

    public static void leftRotateUtil(int[] arr) {
        int temp = arr[0];
        int i;
        for (i = 0; i < arr.length - 1 ; i++) {
             // Replace every element with next element
             arr[i] = arr[i+1];
        }
        // Last element gets replaced with first element
        arr[i] = temp;
    }
}
