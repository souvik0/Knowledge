package arrayString;

public class MonotonicArrayCheck {

    public static void main(String[] args) {
        int [] arr = {1,2,4,5};
        boolean ans = isMonotonic(arr);
        System.out.println(ans);
    }

    public static boolean isMonotonic(int[] arr) {
        boolean isIncrementing = true;
        boolean isDecrementing = true;
        for (int i = 0 ; i < arr.length - 1; i++) {
             if (arr[i] > arr[i+1]) {
                 isIncrementing = false;
             } else if (arr[i+1] > arr[i]){
                 isDecrementing = false;
             }
        }
        return isIncrementing || isDecrementing;
    }
}
