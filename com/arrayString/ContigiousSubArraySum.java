package com.arrayString;

// It gives only one sub array which is the first one

import java.util.HashMap;

public class ContigiousSubArraySum {

    public static void main(String[] args) {
        int arr[] = {-35, 15, 2, 4, -5, 8, 9, 5, 10, -20, -45};
        int arr2[] = {15, 2, 4, -5, 8, 9, 5, 10, -20, -45};
        int arr3[] = {-2, -1, 1, 4, -2, -3, 6, 8, 11};
        int givenSum = 15;
        findSubArrayNonNegetive(arr2, givenSum);
        //findSubArrayWithNegetive(arr, givenSum);
        findSubArrayWithNegetive(arr3, MaximumSubArray.maximumSubArray(arr3));
    }

    public static void findSubArrayNonNegetive(int[] arr, int givenSum) {
       int left = 0;
       int right = 0;
       int currentSum = arr[0]; // consider currentSum as first element only

       for (int i = 1 ; i < arr.length ; i++) {

            if (currentSum == givenSum) {
                right = i - 1;
                System.out.println("Sum found between indexes " + left + " and " + right);
            }

            if (currentSum > givenSum && left < i - 1) {
                currentSum = currentSum - arr[left];
                left++;
            }

            if (right < arr.length) {
                currentSum = currentSum + arr[i];
                right++;
            }
       }
    }

    // This method also used to find out existence of Maximum subraay
    public static void findSubArrayWithNegetive(int[] arr, int givenSum) {
        int left = 0;
        int right = -1; // to check present location
        int currentSum = 0;

        // This map hold currentSum as key & array index of the currentSum as value
        HashMap<Integer, Integer> hashMap = new HashMap<>();  //Keeping sum & index of that sum

        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];

            //the sub array is starting from index 0- so stop 
            if (currentSum == givenSum) {
                right = i;
                break;
            }

            //if hashMap already has the value, means we already  
            //have sub Array with the sum - so stop 
            if (hashMap.containsKey(currentSum - givenSum)) {
                left = hashMap.get(currentSum - givenSum) + 1;
                right = i;
                break;
            }

            //if value is not present then add to hashMap 
            hashMap.put(currentSum, i);
        }

        // if end is -1 : means we have reached end without the sum 
        if (right == -1) { 
            System.out.println("No subarray with given sum exists"); 
        } else { 
            System.out.println("Negtive with Sum found between indexes " + left + " to " + right);
        } 
    }
}