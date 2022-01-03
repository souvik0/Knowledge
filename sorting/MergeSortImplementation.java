package sorting;

// Merge sort is based on divide & concquer rule
/* Best case: O(nlogn)
   Average case: O(nlogn)
   Worst case: O(nlogn)
*/
public class MergeSortImplementation {

    //private static int[] arr = {100,20,15,30,5,75,40};
    public static void main(String args[]) {
        int[] arr = {100,20,15,30,5,75,40};
        // Print array before merge sort
        System.out.println("Array before sorting: ");
        printArray(arr,0,arr.length-1);

        System.out.println("-----------------------------");
        mergeSort(arr, 0,arr.length-1);

        System.out.println("-----------------------------");
        // Print array after sorting
        System.out.println("Array After sorting: ");
        printArray(arr, 0, arr.length-1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        int mid = left + (right-left)/2;

        if (left < right) {
            // Divide left side of element of the array up to single element array creation
            mergeSort(arr, left, mid);
            // Divide right side of element of the array up to single element array creation
            mergeSort(arr, mid + 1, right);
            // Concur all the sub arrays
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] tempArray = new int[arr.length];
        int tempArrayStartIndex = start;

        int startIndex = start;
        int midIndex = mid + 1;

        while (startIndex <= mid && midIndex <= end) {
            // Need to compare each element starting from 0th index of the given array to fill up tempArray
            if (arr[startIndex] < arr[midIndex]) {
                tempArray[tempArrayStartIndex++] = arr[startIndex++];
            } else {
                tempArray[tempArrayStartIndex++] = arr[midIndex++];
            }
        }

        // Adjust rest of the elements
        while (startIndex <= mid) {
            tempArray[tempArrayStartIndex++] = arr[startIndex++];
        }

        while (midIndex <= end) {
            tempArray[tempArrayStartIndex++] = arr[midIndex++];
        }

        // Copy tempArray to actual array after sorting 
        for (int i = start; i <= end; i++) {
             arr[i] = tempArray[i];
        }
    }

    public static void printArray(int arr[], int start, int end) {
        for (int i = start; i <= end; i++) {
             System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}