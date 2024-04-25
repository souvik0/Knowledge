package com.arrayString;

import java.util.Arrays;

public class TripletSumClosest {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(closestTripletSum(nums, target));
    }

    public static int closestTripletSum(int[] arr, int givenSum) {
        int closestSum = arr[0] + arr[1] + arr[2];

        Arrays.sort(arr);
        for (int i = 0 ; i < arr.length; i++) {
             int x = arr[i];
             int left = i + 1;
             int right = arr.length - 1;

             while (left < right) {
                 int currentSum = x + arr[left] + arr[right];
                 // If the current sum is closer to the target than the previous closest, update closestSum
                 if (Math.abs(currentSum - givenSum) < Math.abs(closestSum - givenSum)) {
                     closestSum = currentSum;
                 } else if (currentSum > givenSum) {
                     right --;
                 } else if (currentSum < givenSum){
                     left++;
                 }
             }
        }
        return closestSum;
    }
}
