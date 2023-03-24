package com.recursion;

import java.util.ArrayList;
import java.util.List;;

public class GenerateSubsetsFromString {

    public static void main(String[] args) {
        String str = "xy";
        List<List<Character>> subsets = subsets(str.toCharArray());
 
        for (List<Character> subset: subsets) {
            System.out.println(subset.toString());
        }
    }

    public static List<List<Character>> subsets(char[] nums) {
        List<List<Character>> finalList = new ArrayList<>();
        subsetsHelper(finalList, new ArrayList<>(), nums, 0);
        return finalList;
    }

    private static void subsetsHelper(List<List<Character>> finalList , List<Character> resultList,
                               char [] nums, int start){
        finalList.add(new ArrayList<>(resultList));

        for (int i = start; i < nums.length; i++){
            // add element
            resultList.add(nums[i]);
            // Explore
            subsetsHelper(finalList, resultList, nums, i + 1);
            // Backtracking
            resultList.remove(resultList.size() - 1);
        }
    }
}
