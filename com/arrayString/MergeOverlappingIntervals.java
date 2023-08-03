package com.arrayString;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        Interval[] arr = new Interval[4];
        arr[0] = new Interval(8, 10);
        arr[1] = new Interval(10, 12);
        arr[2] = new Interval(14, 16);
        arr[3] = new Interval(16, 19);
        mergeOverlappingIntervals(arr);
    }

    // Function that takes a set of intervals, merges 
    // overlapping intervals and prints the result 
    public static void mergeOverlappingIntervals(Interval[] intervalArr) { 
        // Sort Intervals in increasing order of start time 
        Arrays.sort(intervalArr, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        int index = 0; // Stores index of last element in output array (modified arr[])

        // Traverse all input Intervals 
        for (int i = 1; i < intervalArr.length; i++) {
            // If this is not first Interval and overlaps with the previous one
            if (intervalArr[index].end >= intervalArr[i].start) {
                // Merge previous and current Intervals
                intervalArr[index].end = Math.max(intervalArr[index].end, intervalArr[i].end);
            } else {
                index++;
                // To compare with the next Interval object
                intervalArr[index] = intervalArr[i];
            }
        }

        // Now arr[0..index-1] stores the merged Intervals
        System.out.print("All merged Intervals are: ");
        for (int j = 0; j <= index; j++) {
            System.out.print("[" + intervalArr[j].start + "," + intervalArr[j].end + "]");
        }
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
