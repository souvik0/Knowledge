package com.arrayString;

public class AnyBaseToDecimalConversion {

    public static void main(String[] args) {
        String str = "1172";
        int base = 8;
        System.out.println("Decimal equivalent of " + str + " in base "+ base + " is "+ " " +
                           convertToDecimal(str, base));
    }

    // Function to convert a number from given base 'b' to decimal
    public static int convertToDecimal(String str, int base) {
        int len = str.length();
        int power = 1; // Initialize power of base
        int num = 0; // Initialize result
        int i;

        // Decimal equivalent is str[len-1]*1 + str[len-2] * base + str[len-3]*(base^2) + ...
        for (i = len - 1; i >= 0; i--) {
            // A digit in input number must be less than number's base
            if (val(str.charAt(i)) >= base) {
                System.out.println("Invalid Number");
                return -1;
            }

            num += val(str.charAt(i)) * power;
            power = power * base;
        }

        return num;
    }

    // To return value of a char. For example, 2 is returned for '2'. 10 is returned
    // for 'A', 11 for 'B'
    public static int val(char c) {
        if (c >= '0' && c <= '9') {
            return (int)c - '0';
        } else {
            return (int)c - 'A' + 10;
        }
    }
}
