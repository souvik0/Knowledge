package arrayString;

public class SegregateZeroOne {

    public static void main(String[] args) {
        int arr[] = {1, 0, 1, 1, 0, 1}; 
        segregateZeroOne(arr); 
        System.out.print("Array after segregation "); 
        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i]+" ");
    }

    public static void segregateZeroOne(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            while (arr[left] == 0) {
                left++;
            }
            while (arr[right] == 1) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
}