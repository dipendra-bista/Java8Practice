package com.punojsoft.java8practice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamFindAndRemoveDuplicateExample {
    public static void main(String[] args) {
// ArrayList with duplicate elements
        ArrayList<Integer> numbersList
                = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
        /**
         * case 1: Stream.distinct()
         */
        numbersList.stream().distinct().forEach(System.out::println);
        /**
         *case ii: Collectors.toSet()
         */
        numbersList.stream().collect(Collectors.toSet()).forEach(System.out::println);
        /**
         *case iii:Sometimes we are intersted in finding out that which
         * all elements are duplicates and how many times they appeared
         * in the original list
         */

        Map<Integer, Long> elementCountMap = numbersList.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
        System.out.println(elementCountMap);
    }
}
