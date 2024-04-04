package com.recursion;

public class PowerCalculation {

    public static void main(String[] args) {
        int base = 5, power = 5;
        int result = powerCalculator(base, power);
        System.out.println(base + "^" + power + " = " + result);
    }

    public static int powerCalculator(int base, int power) {
        if (power != 0) {
            // recursive call to power()
            return (base * powerCalculator(base, power - 1));
        } else {
            return 1;
        }
    }
}
