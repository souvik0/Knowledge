package com.stackQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SunsetView {

    public static void main(String[] args) {
    }

    public static void sunsetView(int[] buildingHeight, String direction) {
        Stack<Integer> buildingPosition = new Stack<Integer>();
        List<Integer> sunsetViewBuilding = new ArrayList<Integer>();

        if ("WEST".equals(direction)) {
            buildingPosition.push(buildingHeight[0]);
            sunsetViewBuilding.add(0);
            for (int i = 1; i < buildingHeight.length; i++) {
                 if (!buildingPosition.isEmpty() && buildingHeight[i] > buildingPosition.peek()) {
                     sunsetViewBuilding.add(i);
                 }
            }
        }

        if ("EAST".equals(direction)) {
            buildingPosition.push(buildingHeight[buildingHeight.length - 1]);
            sunsetViewBuilding.add(buildingHeight.length - 1);
            for (int i = buildingHeight.length - 2; i >= 0 ; i--) {
                 if (! buildingPosition.isEmpty() && buildingHeight[i] > buildingPosition.peek()) {
                     sunsetViewBuilding.add(i);
                 }
            }
        }

        System.out.println(sunsetViewBuilding.toString());
    }
}
