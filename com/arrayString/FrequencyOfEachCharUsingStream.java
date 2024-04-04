package com.arrayString;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfEachCharUsingStream {

    public static void main(String[] args) {
        String str = "Hello World!";

        Map<Character, Long> frequencyMap =
            str.chars()
               .mapToObj(c -> (char)c)
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Print the frequency of each character
        frequencyMap.forEach((character, frequency) -> System.out.println(character + " : " + frequency));
    }
}
