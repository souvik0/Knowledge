package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutationWithDuplicates {

    public static void main(String[] args) {
        ArrayPermutationWithDuplicates pa = new ArrayPermutationWithDuplicates();
        int[] arr = {10, 20, 30};

        List<List<Integer>> permute = pa.permute(arr);

        System.out.println("Permuations of array : [10, 20, 30] are:");
        System.out.println("=========================================");

        for(List<Integer> perm : permute) {
            System.out.println(perm);
        }
    }

    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), arr);
        return list;
    }

    private void permuteHelper(List<List<Integer>> finalList, List<Integer> resultList, int [] arr){
        // Base case or recursion break condition
        if (resultList.size() == arr.length){
            finalList.add(new ArrayList<>(resultList));
        }
        else {
            for (int i = 0; i < arr.length; i++){
                // Choose element
                resultList.add(arr[i]);
                permuteHelper(finalList, resultList, arr);

                // Backtracking of elements to get more number of different combinations
                resultList.remove(resultList.size() - 1);
            }
        }
    }
}
