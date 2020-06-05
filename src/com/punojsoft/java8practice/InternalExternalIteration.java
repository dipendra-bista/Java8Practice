package com.punojsoft.java8practice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class InternalExternalIteration {
    public static void main(String[] args) {
        /**
         * External Iteration
         * Java foreach/iterator le sequentially each element  lai
         * process garxa at the orcer specified by the Collection
         * So ,order guarantee garnu parne vayeko le performance slow hunxa
         * yasma ma,what and how both part specify garnuparxa
         */
        List<String> alphabets = Arrays.asList(new String[]{"a", "b", "b", "d"});

        for (String alphabet : alphabets) {
            System.out.println(alphabet.toUpperCase());
        }
        //        or
        Iterator<String> iterator = alphabets.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        /**
         * Internal iteration
         * here ,client let the library handle how how part
         * and only provide the what part.
         */
        alphabets.forEach(s -> System.out.println(s));
        //          or
        alphabets.forEach(System.out::println);
        //          or
        Consumer<String> stringConsumer = s -> System.out.println(s);
        alphabets.stream().forEach(stringConsumer);

    }
}
