package arrayString;

import java.util.Arrays;

public class SortedSquaredArray {

    public static void main(String[] args) {
        int arr[] = {-6, -3, -1, 2, 4, 5 };
        int n = arr.length;
 
        System.out.println("Before sort ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
 
        sortSquares(arr);
        System.out.println("");
        System.out.println("After Sort ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sortSquares(int arr[]) {
        int n = arr.length;
 
        // First convert each array elements into its square & replace at the same index
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * arr[i];
        }
 
        // Sort an array using "inbuild sort function"
        // in Arrays class.
        Arrays.sort(arr);
    }
}
