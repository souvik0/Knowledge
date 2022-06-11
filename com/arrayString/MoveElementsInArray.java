package com.arrayString;
// Moving the specified element to the end of an array
public class MoveElementsInArray {

    public static void main(String[] args) {
        int []arr = {1, 1, 3, 5, 6};
        int K = 1;
        int []ans = moveElement(arr, K);

        for(int i = 0; i < arr.length; i++)
           System.out.print(ans[i] + " ");
    }

    public static int[] moveElement(int[] array, int toMove) {
        int left = 0;
        int right = array.length -1;
        while (left < right) {
            // There is nothing to move
            while (left < right && array[right] == toMove) {
                  right--;
            }
            if (array[left] == toMove) {
                // swap first & last element
                array = swap(array, left, right);
            }
            left++;
        }
        return array;
    }

    public static int[] swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        return array;
    }
}
