package com.punojsoft.java8practice.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class InterableanditeratorExample {
    public static void main(String[] args) {
        /**
         *Iterable to stream
         */
        Iterable<String> iterable = Arrays.asList("a", "b", "c");
        Stream<String> stream = StreamSupport.stream(iterable.spliterator(), false);
        stream.forEach(System.out::println);
        /**
         * Iterator to stream
         */
        Iterator<String> iterator = Arrays.asList("b", "b", "c").listIterator();
        Spliterator<String> spliterator = Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED);
        Stream<String> stream1 = StreamSupport.stream(spliterator, false);
        stream1.forEach(System.out::println);
    }
}
