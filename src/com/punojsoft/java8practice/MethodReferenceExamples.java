package com.punojsoft.java8practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * alternative to lamda expression
 */
public class MethodReferenceExamples {
    public static void main(String[] args) {
        /**
         *case 1.Method reference to static method
         *class::staticMethodName
         */
        List<Integer> integers = Arrays.asList(1, 12, 433, 5);
        Optional<Integer> max = integers.stream().reduce(Math::max);
        max.ifPresent(value -> System.out.println(value));
        /**
         *case 2.method reference to instance method from instance
         * ClassInstance::instanceMethodName
         * In above example we can rewrite sout by method ferefence
         * to instance method from instance
         */
        max.ifPresent(System.out::println);

        /**
         *case 3. Method reference to instance method from class type
         * class::instanceMethodName
         */
        List<String> strings = Arrays
                .asList("how", "to", "do", "in", "java", "dot", "com");

        List<String> sortedString = strings.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
        System.out.println(sortedString);

        //or
        List<String> sortedAlt = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(sortedAlt);
        /**
         * Case 3.Reference to constructor
         * Class::new
         *eg.creating list of integers from 1 to 100.
         */

        List<Integer> integers1 = IntStream.range(1, 100)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Optional<Integer> min = integers1.stream()
                .reduce(Math::min);

        min.ifPresent(System.out::println);
    }
}
