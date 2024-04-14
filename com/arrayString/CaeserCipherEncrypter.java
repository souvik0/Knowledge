package com.arrayString;

// Here this problem is solved with the help of ascii code
public class CaeserCipherEncrypter {

    public static void main(String[] args) {
        System.out.println(shiftLetters("SouvikPupu 424", 6));
    }

    public static String shiftLetters(String str, int key) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                char shifted = (char) (((c - 'a' + key) % 26) + 'a');
                encrypted.append(shifted);
            } else {
                // If the character is not a letter, keep it unchanged
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }
}
