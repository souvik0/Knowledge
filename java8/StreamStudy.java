package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStudy {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream();
        Integer lastElement = stream.reduce((first, second) -> second).orElse(-1);
        System.out.println(lastElement);

        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);
        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        List<Integer> listOfAllIntegers = listOfLists.stream()
                                                     .flatMap(eachList -> eachList.stream())
                                                     .collect(Collectors.toList());
        System.out.println(listOfAllIntegers);

        System.out.println(Stream.of("H", "I", "J", "K").reduce((first, second) -> second).get());
        System.out.println(Stream.empty().reduce((first, second) -> second).orElse(-1));
        Stream.empty().reduce((first, second) -> second).orElseThrow(IllegalStateException::new);
    }
}
