package com.recursion;

import java.util.ArrayList;
import java.util.List;;

public class GenerateSubsetsFromString {

    public static void main(String[] args) {
        String str = "xyxz";
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

    private static void subsetsHelper(List<List<Character>> finalList, List<Character> resultList,
                               char [] pattern, int start){
        finalList.add(new ArrayList<>(resultList));

        for (int i = start; i < pattern.length; i++){
            // Avoid duplicates
            if (resultList.contains(pattern[i])) {
                continue;
            }
            // add element
            resultList.add(pattern[i]);
            // Explore
            subsetsHelper(finalList, resultList, pattern, i + 1);
            // Backtracking
            resultList.remove(resultList.size() - 1);
        }
    }
}
