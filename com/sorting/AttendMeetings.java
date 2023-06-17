package com.sorting;

/*
 * Given a list of meeting intervals where each interval consists of a start and an end time,
 * check if a person can attend all the given meetings such that only one meeting can be 
 * attended at a time.
 * {
 * "intervals": [[1, 5], [5, 8], [10, 15]]
 * }
 */

import java.util.Arrays;
import java.util.Comparator;

public class AttendMeetings {

    public static void main(String[] args) {
        int meetingIntervals[][] = new int[][] {{1, 5},
                                                {3, 8},
                                                {10, 15}};
        System.out.println("Person can attend all the meetings: " + can_attend_all_meetings(meetingIntervals));
    }

    public static boolean can_attend_all_meetings(int[][] meetingIntervals) {
        Arrays.sort(meetingIntervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });

        for (int i = 0; i < meetingIntervals.length - 1; i++) {
            if (meetingIntervals[i][1] > meetingIntervals[i + 1][0]) {
                return false;
            }
        }

        return true;
    }
}
