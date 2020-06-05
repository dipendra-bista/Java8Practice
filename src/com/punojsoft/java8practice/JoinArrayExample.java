package com.punojsoft.java8practice;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * example of joining array to produce single string
 */
public class JoinArrayExample {
    public static void main(String[] args) {
        /**
         * String.Join() has two overloaded method
         */
        //example 1:
        System.out.println(String.join(" ", "How ", "to", "do", "in", "java!").toString());

        //example 2:
        List<String> fullName = Arrays.asList("Dipendra", "Bista");
        System.out.println(String.join("_", fullName));
        /**
         *Java8 StringJoiner example
         */
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        stringJoiner.add("How")
                .add("To")
                .add("Do")
                .add("In").add("Java");

        System.out.println(stringJoiner.toString());

        List<String> numbers = Arrays.asList("How", "To", "Do", "In", "Java");
        String joinedString = numbers.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(joinedString);
        /**
         * another example would be using StringUtils.join()
         * by using apache commons-lang3 dependency
         */
    }
}
