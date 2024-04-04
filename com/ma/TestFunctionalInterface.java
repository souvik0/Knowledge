package com.ma;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestFunctionalInterface {

    public static void main(String[] args) throws IOException {
        MyFunctionallnterface<String> mfi = (name) -> {
            System.out.println("Hello : " + name);
        };
        mfi.display("souvik"); // Deducing from the context
        mfi.move();
        MyFunctionallnterface.moveAgain();
        System.out.println(mfi.toString());

        String maxChar = Stream.of("H", "T", "D", "I", "J")
                               .max(String::compareTo)
                               .get();
        System.out.println(maxChar);

        Integer maxNumber = Stream.of(10, 20, 30, 50, 80, 5, 8)
                                  .map(Integer::valueOf)
                                  .max(Integer::compareTo)
                                  .get();
        System.out.println("Maximum number: " + maxNumber);

        String dirLocation = "C:/Users/Admin/Dropbox";

        // Getting hidden files
        List<File> hiddenFilesList = Files.list(Paths.get(dirLocation))
                                          .map(Path::toFile)
                                          .filter(File::isHidden)
                                          .collect(Collectors.toList());
        hiddenFilesList.forEach(System.out::println);

        // Getting files with specific extension
        List<File> regularFileList = Files.list(Paths.get(dirLocation))
                                          .filter(eachPath -> eachPath.toString().endsWith(".java"))
                                          .map(Path::toFile)
                                          .filter(File::isFile)
                                          .collect(Collectors.toCollection(ArrayList::new));
        regularFileList.forEach(System.out::println);

        try {
            for (Path path : Files.newDirectoryStream(Paths.get(dirLocation), path -> path.toFile().isFile())) {
                path = path.normalize();
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            // Error while reading the directory
        }
    }
}