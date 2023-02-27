package com.arrayString;

public class EquilibriumPoint {

    public static void main(String[] args) {
        EquilibriumPoint equi = new EquilibriumPoint();
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        int arr_size = arr.length;
        System.out.println("Equilibrium index is " +
                          equi.equilibrium(arr, arr_size));
    }

    public int equilibrium(int arr[], int n) {
        int sum = 0; // initialize sum of whole array
        int leftsum = 0; // initialize leftsum

        /* Find sum of the whole array */
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }

        for (int i = 0; i < n; i++) {
            sum = sum - arr[i]; // This represent right sum

            if (leftsum == sum) {
                return i;
            }

            leftsum = leftsum + arr[i];
        }

        /* If no equilibrium index found, then return 0 */
        return -1;
    }
}
