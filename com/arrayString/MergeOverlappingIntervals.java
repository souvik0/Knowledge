package com.arrayString;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        Interval arr[] = new Interval[4];
        arr[0] = new Interval(6,8);
        arr[1] = new Interval(1,9);
        arr[2] = new Interval(2,4);
        arr[3] = new Interval(4,7);
        mergeIntervals(arr);
    }

    // Function that takes a set of intervals, merges 
    // overlapping intervals and prints the result 
    public static void mergeIntervals(Interval arr[]) { 
        // Sort Intervals in increasing order of start time 
        Arrays.sort(arr, new Comparator<Interval>() {
            public int compare(Interval i1,Interval i2) {
                return i1.start - i2.start;
            }
        });

        int index = 0; // Stores index of last element in output array (modified arr[])

        // Traverse all input Intervals 
        for (int i = 1; i < arr.length; i++) {
            // If this is not first Interval and overlaps
            // with the previous one
            if (arr[index].end >= arr[i].start) {
                // Merge previous and current Intervals
                arr[index].end = Math.max(arr[index].end, arr[i].end);
            }
            else {
                index++;
                arr[index] = arr[i];
            }
        }

        // Now arr[0..index-1] stores the merged Intervals
        System.out.print("The Merged Intervals are: ");
        for (int j = 0; j <= index; j++) {
            System.out.print("[" + arr[j].start + "," + arr[j].end + "]");
        }
    }
}

class Interval {
    int start,end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
