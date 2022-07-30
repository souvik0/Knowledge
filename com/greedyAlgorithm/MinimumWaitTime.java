package com.greedyAlgorithm;

import java.util.Arrays;

public class MinimumWaitTime {

    public static void main(String[] args) {
        int[] quiries = new int[] {3, 2, 1, 2, 6};
        System.out.println(minimumWaitTime(quiries));
    }

    public static int minimumWaitTime(int[] quiries) {
        Arrays.sort(quiries);

        int totalWaitingTime = 0;
        for (int i = 0; i < quiries.length; i++) {
             int durationOfExecution = quiries[i];
             int queriesLeftForExecution = quiries.length - (i + 1);
             totalWaitingTime += durationOfExecution * queriesLeftForExecution;
        }
        return totalWaitingTime;
    }
}
