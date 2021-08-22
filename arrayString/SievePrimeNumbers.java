package arrayString;

import java.util.Arrays;

public class SievePrimeNumbers {

    public static void main(String[] args) {
       int range = 200;
       sieveOfErotothenis(range);
    }

    public static void sieveOfErotothenis(int range) {
        boolean[] primeChecker = new boolean[range];
        Arrays.fill(primeChecker, true);

        // 1 is not a prime number, so eliminate 1 at the starting.
        // Finding out multipliers of the number with square root of range
        for (int j = 2; j < Math.sqrt(range); j++) {
            if (primeChecker[j] == true) {
                for (int k = (j*j); k < range; k = k+j) {
                     primeChecker[k] = false;
                }
            }
        }

        System.out.println("List of prime numbers upto given range are : ");
        for (int i = 2; i < primeChecker.length; i++) {
           if (primeChecker[i] == true) {
               System.out.println(i);
           }
        }
    }
}