package com.arrayString;

import java.util.ArrayList;
import java.util.List;

public class RotateArray {

    public static void main(String[] args) {
        int[] inputArray = new int[] {1, 2, 3, 4, 5, 6, 7};
        List<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputArray.length; i++) {
            inputList.add(inputArray[i]);
        }

        int k = 3;
        rotateArray(inputList, k);
    }

    public static void rotateArray(List<Integer> inputList, int k) {
        List<Integer> tempList = new ArrayList<Integer>();
        int i = 0;

        while (i <= k) {
            tempList.add(inputList.get(i));
            i++;
        }

        mergeList(inputList.subList(k + 1, inputList.size()), tempList);
    }

    public static void mergeList(List<Integer> list1, List<Integer> list2) {
        List<Integer> resultList = new ArrayList<Integer>();
        for (Integer i : list1) {
            resultList.add(i);
        }
        for (Integer j : list2) {
            resultList.add(j);
        }

        resultList.stream().forEach(System.out::println);
    }
}
