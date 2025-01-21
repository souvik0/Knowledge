package com.arrayString;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfOccuranceInListUsingStream {

    public static void main(String[] args) {
        List<String> ls = new ArrayList<String>();
        ls.add("Pradeep");
        ls.add("Test");
        ls.add("ABC");
        ls.add("Pradeep");
        ls.add("Test");
        ls.add("Pradeep");

        ls.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
          .forEach((element, frequency) -> System.out.println(element + " : " + frequency));
    }
}
