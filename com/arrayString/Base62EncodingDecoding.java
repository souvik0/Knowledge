package com.arrayString;

import java.util.*;

public class Base62EncodingDecoding {

    private static final String BASE62_CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Map<Character, Integer> BASE62_MAP = new HashMap<>();

    static {
        for (int i = 0; i < BASE62_CHARACTERS.length(); i++) {
            BASE62_MAP.put(BASE62_CHARACTERS.charAt(i), i);
        }
    }

    public static void main(String[] args) {
        long number = 154324768; // Number to encode
        String encoded = encode(number);
        System.out.println("Encoded: " + encoded);

        long decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);
    }

    public static String encode(long input) {
        StringBuilder encodedString = new StringBuilder();

        while (input > 0) {
            int remainder = (int) (input % 62);
            encodedString.insert(0, BASE62_CHARACTERS.charAt(remainder));
            input /= 62;
        }

        return encodedString.toString();
    }

    // Get character from BASE62_MAP
    public static long decode(String input) {
        long decodedValue = 0;
        int len = input.length();

        for (int i = 0; i < len; i++) {
            decodedValue += BASE62_MAP.get(input.charAt(i)) * Math.pow(62, len - i - 1);
        }

        return decodedValue;
    }
}
