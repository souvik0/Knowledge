package com.arrayString;

// Remove duplicate without using any extra map object
import java.util.Arrays;

public class RemoveDupicateEfficiently {

    public static void main(String[] args) {
         int arr[] = {10,70,30,90,20,20,30,40,70,50,20}; // unsorted array

         // Below algorithm works on sorted array. So the array has to be sorted first
         // Because duplicate elements will sit right after each other inside array
         Arrays.sort(arr);

         int[] tempArray = removeDuplicate(arr);

         // printing array elements  
         for (int i = 0; i < tempArray.length; i++) {
             System.out.print(tempArray[i]+" ");  
         }
     }

    public static int[] removeDuplicate(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
           System.out.println("No duplicate present");
        }

        int[] tempArr = new int[arr.length];
        int j = 0;

        // Shouldn't consider the last element, otherwise it will throw ArrayIndexOutOfBoundException
        for (int i = 0; i < arr.length - 1 ; i++) {
             if (arr[i] != arr[i+1]) {
                 tempArr[j++] = arr[i];
             }
        }

        // inserting last element
        tempArr[j++] = arr[arr.length - 1];

        return tempArr;
    }
}