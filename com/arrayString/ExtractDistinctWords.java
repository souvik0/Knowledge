package com.arrayString;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtractDistinctWords {

    public static void main(String[] args) throws IOException {
         // Finding out distinct words from a file
         try {
             Files.lines(Paths.get("c:\\demo.txt"))
                  .map(eachLine -> eachLine.split("[\\s]+"))
                  .flatMap(Arrays::stream)
                  .distinct()
                  .forEach(System.out::println);
         } catch (IOException e) {
             e.printStackTrace();
         }

         System.out.println("////////////////////////");
         // The source directory
         String directory = "C:/Users/Admin/Dropbox";

         // Reading only files from the directory while traversing the directory
         // Files.list returns Stream<Path>
         try {
             List<File> fileList = Files.list(Paths.get(directory))
                                        .map(Path::toFile)
                                        .filter(File::isFile)
                                        .collect(Collectors.toList());

             fileList.forEach(System.out::println);
         } catch (IOException e) {
             e.printStackTrace();
         }

         System.out.println("///////////////////////");

         // Traversing directory & sub-directory
         try (Stream<Path> streamOfPaths = Files.walk(Paths.get(directory))) {
             List<Path> pathList = streamOfPaths.map(Path::normalize)
                                                .filter(Files::isRegularFile)
                                                .collect(Collectors.toCollection(ArrayList::new));
             pathList.forEach(System.out::println);
         }
    }
}
