package com.punojsoft.java8practice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class StreamRemoveDuplicates {
    public static void main(String[] args) {

        ArrayList<Integer> numbersList
                = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
        /**
         * case 1.
         */
        numbersList.stream().distinct().forEach(System.out::println);
        System.out.println("breaking.................");

        /**
         * case 2:
         */

        numbersList.stream().collect(Collectors.toSet()).forEach(System.out::println);
        Map<Integer, Long> numbers = numbersList.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));

        Function<String, Integer> stringIntegerFunction = s -> s.length();
        System.out.println("length: " + stringIntegerFunction.apply("punoj"));

        BiConsumer<String, Integer> stringIntegerBiConsumer = (s, integer) -> System.out.println("hello" + s + "your age: " + integer);
        stringIntegerBiConsumer.accept("dipendra", 26);
        UnaryOperator<Integer> unaryOperator = integer -> integer * 5;
        System.out.println(unaryOperator.apply(10));
        int age = 10;
        if (age > 18) {
            System.out.println("you are adult!");
        }
        Predicate<Integer> agePredicate = age1 -> age1 > 18;
        agePredicate.test(20);
        if (agePredicate.test(age)) {
            System.out.println("you are adult!");
        }
    }
}
