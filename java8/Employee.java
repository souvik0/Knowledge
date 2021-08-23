package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Employee {

    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        Consumer<Integer> action = i -> {
            if (i % 2 == 0) {
                System.out.println("Even number :: " + i);
            } else {
                System.out.println("Odd  number :: " + i);
            }
        }; 
        numberList.stream().forEach(action);

        // Here map method convert this to internal collection which creates one to many relationship
        /*try {
             Stream <String> lines = Files.lines(Paths.get("c:\\demo.txt"))
                                          .map(eachLine-> eachLine.split("[\\s]+"))
                                          .flatMap(Arrays::stream).distinct();
             lines.forEach(System.out::println);
             lines.close();
         } catch (IOException e) {
             e.printStackTrace();
        } */

        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");
        map1.put(5, "E");

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1, "G");   //It will replace the value 'A'
        map2.put(2, "B");
        map2.put(3, "C");
        map2.put(4, "D");   //A new pair to be added

        mergeMap(map1, map2);
        
        String minChar = Stream.of("H", "T", "D", "I", "J")
                               .min(String::compareTo)
                               .get();
        System.out.println(minChar);
    }

    public static <T>Predicate<T> distinctByKey(Function<? super T, ?> KeyExtractor) {
        ConcurrentHashMap<Object, Boolean> cmap = new ConcurrentHashMap<Object, Boolean>(16, 0.9f, 1);
        return t -> cmap.putIfAbsent(KeyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @SuppressWarnings("unchecked") 
    public static <T>Predicate<T> distinctByKeys(Function<? super T, ?> ...keyExtractor) {
        ConcurrentHashMap<Object, Boolean> cmap = new ConcurrentHashMap<Object, Boolean>(16, 0.9f, 1);
        return t -> {
            final List<?> distinctKeys = Arrays.stream(keyExtractor)
                                               .map(ke -> ke.apply(t))
                                               .collect(Collectors.toList());
            return cmap.putIfAbsent(distinctKeys, Boolean.TRUE) == null;
       };
    }

    public static void mergeMap(HashMap<Integer, String> map1,  HashMap<Integer, String> map2) {
        // All the elements are merged into map1
        map2.forEach((key, value) -> map1.merge(key, value, (v1, v2) ->
                                     v1.equalsIgnoreCase(v2) ? v1 : v1 + "," + v2));
        // Merged map is map1
        System.out.println(map1);
    }

    public static boolean isPrime(int i) {
        IntPredicate isDivisible = index -> i % index == 0;
        return i > 1 && IntStream.range(2, i)
                                 .noneMatch(isDivisible);
    }

    public static void countDuplicateEntries() {
        ArrayList<Integer> numbersList 
            = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
        Map<Integer, Long> elementCountMap = numbersList.stream()
                .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
        System.out.println(elementCountMap);
    }
}