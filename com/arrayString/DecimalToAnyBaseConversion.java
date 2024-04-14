package com.arrayString;

public class DecimalToAnyBaseConversion {

    public static void main(String[] args) {
        int inputNum = 2206;
        int targetBase = 16;
        System.out.println("Equivalent of " + inputNum + " in base "+ targetBase + " is " +
                           decimalToAny(targetBase, inputNum));
    }

    public static String decimalToAny(int targetBase, int inputNum) {
        String result = "";
        // Convert input number is given base by repeatedly dividing it by base and 
        // taking remainder
        while (inputNum > 0) {
            result += convertIntegerToCharacter(inputNum % targetBase);
            inputNum = inputNum/ targetBase;
        }

        StringBuilder ix = new StringBuilder();
        // append a string into StringBuilder input1
        ix.append(result);

        // Reverse the result
        return ix.reverse().toString();
    }

    // To return char for a value. For example '2' is returned for 2.
    // 'A' is returned for 10. 'B' for 11
    public static char convertIntegerToCharacter(int num) {
        if (num >= 0 && num <= 9) {
            return (char)(num + 48);
        } else {
            return (char)(num - 10 + 65);
        }
    }
}
