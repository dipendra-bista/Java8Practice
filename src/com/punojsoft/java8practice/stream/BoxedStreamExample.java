package com.punojsoft.java8practice.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * In java 8,if you want to convert stream of object to collection
 * ,then you can use one of the static method in the Collectors class
 */
public class BoxedStreamExample {
    public static void main(String[] args) {
        //It works perfect!
        List<String> stringList = Stream.of("How", "to", "do", "In", "Java")
                .collect(Collectors.toList());

        //same procss doesont works on stream of primitives ,however
//        IntStream.of(1, 2, 3, 4).collect(Collectors.toList());
        /**
         * to convert a stream of primitives ,you must first box the element in their
         * wrapper class.This type of stream is called boxed stream
         */
        List<Integer> integers = IntStream.of(1, 2, 3, 4).boxed().collect(Collectors.toList());
        integers.forEach(System.out::println);

        //        IntStream, LongStream, DoubleStream
    }
}
