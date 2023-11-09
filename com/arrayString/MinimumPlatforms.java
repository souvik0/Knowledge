package com.arrayString;

import java.util.*;

public class MinimumPlatforms {

    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
        int minPlatforms = findMinPlatforms(arrival, departure);
        System.out.println("Minimum Platforms Required: " + minPlatforms);
    }

    public static int findMinPlatforms(int[] arrival, int[] departure) {
        if (arrival == null || departure == null || arrival.length != departure.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int n = arrival.length;
        int minPlatforms = 1; // At least one platform is required
        int result = 1;
        int i = 1;
        int j = 0;

        // Sort the arrival and departure arrays
        Arrays.sort(arrival);
        Arrays.sort(departure);

        // Similar to merge operation in merge sort
        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                minPlatforms++;
                i++;
            } else {
                minPlatforms--;
                j++;
            }

            // Update the result to store the maximum platforms needed at any time
            result = Math.max(result, minPlatforms);
        }

        return result;
    }
}
