package arrayString;

// wHILE FINDING CLOSEST TO ZERO, TRY TP FIND OUT MINIMUM SUM
//THis operation will be performed after sorting the array
import java.util.Arrays;

public class FindPairsClosestToZero {

	public static void main(String[] args) {
        int arr[] = {1, 60, -10, 70, -80, 85};
        findPairs(arr);
	}

    public static void findPairs(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int minleft = 0, minright = 0;
        int minSum = Integer.MAX_VALUE;

        Arrays.sort(arr);

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (Math.abs(currentSum) < Math.abs(minSum)) {
                minSum = currentSum;
                minleft = left;
                minright = right;
                System.out.println("Left: " + arr[minleft] + " : right: " + arr[minright]);
            }
            if (currentSum > 0) {
                right--;
            }
            if (currentSum < 0) {
                left++;
            }
        }
    }
}