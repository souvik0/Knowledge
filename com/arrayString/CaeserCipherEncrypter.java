package com.arrayString;

// Here this problem is solved with the help of ascii code
public class CaeserCipherEncrypter {

    public static void main(String[] args) {
        System.out.println(shiftLetters("SouvikPupu", 2));
    }

    public static String shiftLetters(String str, int key) {
        char[] newLetter = new char[str.length()];
        int newKey = key % 26;
        for (int i = 0; i < str.length(); i++) {
             newLetter[i] = getNewLetter(str.charAt(i), newKey);
        }
    return new String(newLetter);
    }

    public static char getNewLetter(char letter, int key) {
        int newLetterCode = (int) (letter + key);
        return newLetterCode <= 122 ? (char) newLetterCode :
                                      (char) (96 + newLetterCode % 122);
    }
}
