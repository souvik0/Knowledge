package com.greedyAlgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassPhotos {

    public static void main(String[] args) {
        Integer[] redShirtStudentHeight = new Integer[] {5, 8, 1, 3, 4};
        Integer[] blueShirtStudentHeight = new Integer[] {6, 9, 2, 4, 5};
        System.out.println(classPhotos(Arrays.asList(redShirtStudentHeight),
                                       Arrays.asList(blueShirtStudentHeight)));
    }

	public static boolean classPhotos(List<Integer> redShirtStudentHeight, List<Integer> blueShirtStudentHeight) {
       Collections.sort(redShirtStudentHeight);
       Collections.sort(blueShirtStudentHeight);

       String frontRowShirtColor = (redShirtStudentHeight.get(0) < blueShirtStudentHeight.get(0)) ?
                                   "RED" : "BLUE";
       for (int i = 0 ; i < blueShirtStudentHeight.size(); i++) {
            int redShirtHeight = redShirtStudentHeight.get(i);
            int blueShirtHeight = blueShirtStudentHeight.get(i);

            if (frontRowShirtColor == "RED") {
                if (redShirtHeight >= blueShirtHeight) {
                    return false;
                }
            } else {
                if (blueShirtHeight >= redShirtHeight) {
                    return false;
                }
            }
       }
       return true;
    }
}
