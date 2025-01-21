package com.arrayString;
/*
 * Successive multiplication starting from last character of the string has to be performed with increasing power starting from 1.
 * Meanwhile needs to covert the character to Integer to have a mathematical value
 */
public class AnyBaseToDecimalConversion {

    public static void main(String[] args) {
        String str = "F";
        int givenBase = 16;
        System.out.println("Decimal equivalent of " + str + " in base "+ givenBase + " is "+ " " +
                           convertToDecimal(str, givenBase));
    }

    // Function to convert a number from given base 'b' to decimal
    public static int convertToDecimal(String str, int givenBase) {
        int len = str.length();
        int power = 1; // Initialize power of base
        int result = 0; // Initialize result

        // Decimal equivalent is str[len-1]*1 + str[len-2] * base + str[len-3]*(base^2) + ...
        for (int i = len - 1; i >= 0; i--) {
            // Here successive multiplication takes place
            result += convertCharToInteger(str.charAt(i)) * power;
            power = power * givenBase;
        }

        return result;
    }

    public static int convertCharToInteger(char ch) {
        return Character.getNumericValue(ch);
    }
}
