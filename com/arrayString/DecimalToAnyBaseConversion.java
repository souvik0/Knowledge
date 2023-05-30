package com.arrayString;

public class DecimalToAnyBaseConversion {

    public static void main(String[] args) {
        int inputNum = 634, base = 8;
        System.out.println("Equivalent of " + inputNum + " in base "+ base +" is " +
                           fromDeci(base, inputNum));
    }

    public static String fromDeci(int base, int inputNum) {
        String result = "";
        // Convert input number is given base by repeatedly dividing it by base and 
        // taking remainder
        while (inputNum > 0) {
            result += reVal(inputNum % base);
            inputNum /= base;
        }

        StringBuilder ix = new StringBuilder();
        // append a string into StringBuilder input1
        ix.append(result);

        // Reverse the result
        return new String(ix.reverse());
    }

    // To return char for a value. For example '2' is returned for 2.
    // 'A' is returned for 10. 'B' for 11
    public static char reVal(int num) {
        if (num >= 0 && num <= 9) {
            return (char)(num + 48);
        } else {
            return (char)(num - 10 + 65);
        }
    }
}
