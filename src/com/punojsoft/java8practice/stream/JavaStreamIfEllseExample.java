package com.punojsoft.java8practice.stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class JavaStreamIfEllseExample {
    public static void main(String[] args) {
        /**
         * java if else logic in stream using consumer on ForEach
         */
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Consumer<Integer> integerConsumer = integer -> {
            if (integer % 2 == 0) {
                System.out.println("Even Number: " + integer);
            } else {
                System.out.println("Odd Number: " + integer);
            }
        };

//        integerStream.forEach(integerConsumer);

        /**
         *If condition using Filter on stream
         */
        Stream<Integer> integerIterator = integerStream.filter(integer -> integer % 2 == 0);
        integerIterator.forEach(System.out::println);
        /**
         * Reusing the stream
         * if we operated upon stream once we can not used it
         */
        Supplier<Stream<Integer>> streamConsumer = () -> Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = streamConsumer.get().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);
        List<Integer> oddNumbers = streamConsumer.get().filter(integer -> integer % 2 != 0).collect(Collectors.toList());
        System.out.println(oddNumbers);
    }
}
