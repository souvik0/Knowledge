package com.arrayString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WordSearchInFile {

    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt";
        String searchWord = "search";

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            boolean wordFound = lines
                    .flatMap(line -> Stream.of(line.split("\\s+"))) // Split each line into words
                    .anyMatch(word -> word.equals(searchWord)); // Check if any word matches the search word

            if (wordFound) {
                System.out.println("The word '" + searchWord + "' is found in the file.");
            } else {
                System.out.println("The word '" + searchWord + "' is not found in the file.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
