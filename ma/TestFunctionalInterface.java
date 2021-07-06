package com.ma;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestFunctionalInterface {

    public static void main(String[] args) throws IOException {
        MyFunctionallnterface mfi = (name) -> {
            System.out.println("Hello : " + name);
        };
        mfi.display("souvik");
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
        System.out.println("Maximum number: " +maxNumber);

        String dirLocation = "D:/checkin/Gitlab/amc";

        List<File> filesFrom = Files.list(Paths.get(dirLocation))
                .filter(path -> path.toFile().isHidden())
                .map(Path::toFile)
                .collect(Collectors.toList());

        List<File> files = Files.list(Paths.get(dirLocation))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".java"))
                .map(Path::toFile)
                .collect(Collectors.toCollection(ArrayList::new));

        files.forEach(System.out::println);

        try {
            for (Path path : Files.newDirectoryStream(Paths.get(dirLocation), path -> path.toFile().isFile())) {
                path = path.normalize();
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            // Error while reading the directory
        }

        String anotherDate = "04 Apr 2016";

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MM yyyy");
        LocalDate random = LocalDate.parse(anotherDate, df);

        System.out.println(anotherDate + " parses as " + random);
    }
}