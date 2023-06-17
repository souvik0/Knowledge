package com.arrayString;

// It is similar approach as binary search
// The given is sorted in nature containing only 0 & 1.
// This will resolve where all 1's & 0's are together
public class IndexofFirstOne {

    public static void main(String[] args) {
        int arr[] = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1}; 
        int left = 0;
        int right = arr.length -1; 
        System.out.println(indexOfFirstOne(arr, left, right)); 
    }

    public static int indexOfFirstOne(int arr[], int left, int right) {
        while (left <= right) {
            int mid = (left + right)/2; 
             // if true, then 'mid' is the index of first '1' 
            // Cater no '0' present condition also.
            if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0)) {
                return mid; 
            } else if (arr[mid] == 1) {// first 1 lies at left of mid
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; 
    }
}
