package com.sorting;

/*
 * Given a list of meeting intervals where each interval consists of a start and an end time,
 * check if a person can attend all the given meetings such that only one meeting can be 
 * attended at a time.
 * {
 * "intervals": [[1, 5], [5, 8], [10, 15]]
 * }
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class AttendMeetings {

    public static void main(String[] args) {
    }

    public static Integer can_attend_all_meetings(ArrayList<ArrayList<Integer>> intervals) {
        int[][] intervalsArray = intervals.stream()
                                          .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                                          .toArray(int[][]::new);
        Arrays.sort(intervalsArray, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        for (int i = 0; i < intervalsArray.length - 1; i++) {
            if (intervalsArray[i][1] > intervalsArray[i + 1][0]) {
               return 0;
            }
        }
        return 1;
    }
}
