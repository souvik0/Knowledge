package com.arrayString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ExtractDistinctWords {

    public static void main(String[] args) {
         try {
             Files.lines(Paths.get("c:\\demo.txt"))
                  .map(eachLine -> eachLine.split("[\\s]+"))
                  .flatMap(Arrays::stream)
                  .distinct()
                  .forEach(System.out::println);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
