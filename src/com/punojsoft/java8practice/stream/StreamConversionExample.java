package com.punojsoft.java8practice.stream;

import model.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConversionExample {
    public static void main(String[] args) {
        Supplier<Stream<String>> tokenStream = () -> Arrays.asList("A", "B", "C", "D").stream();  //stream
        /**
         * 1:stream to array conversion
         * #####################################
         * #####################################
         * case i:
         */

        String[] tokenArray = tokenStream.get().toArray(String[]::new);
        System.out.println(Arrays.toString(tokenArray));
        /**
         * case ii:infinite stream to array conversion
         *To convert infinite stream into array we must first convert
         * into finite stream
         */
        Supplier<IntStream> infiniteStream = () -> IntStream.iterate(1, i -> i + 1);
        System.out.println(Arrays.toString(infiniteStream.get().limit(10).toArray()));

        /**
         * case iii:Infinite stream to array to Integers{Boxed stream}
         */
        Integer[] integers = infiniteStream.get().limit(20)
                .boxed()
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers));
        /**
         * #######################################
         * #######################################
         * 2.Convert stream into list
         * case i.convert stream of string to ArrayList
         */
        List<String> tokenList = tokenStream.get().collect(Collectors.toList());
        /**
         * does not need to override toString()
         */
        System.out.println(tokenList);
        /**
         * case ii.Convert Stream of string to LinkedList
         */

        List<String> tokenLinkedList = tokenStream.get().collect(Collectors.toCollection(LinkedList::new));
        System.out.println(tokenLinkedList);

        /**
         * case iii.convert stream to list for filtered elements
         */
        List<String> filterList = tokenStream.get().filter(s -> s.equals("A") || s.equals("B")).collect(Collectors.toList());
        System.out.println(filterList);
        /**
         * case iv.convert infinite stream to list
         */
        List<Integer> integers1 = infiniteStream.get().limit(10).boxed().collect(Collectors.toList());
        System.out.println(integers1);
        /**
         * #######################################
         * #######################################
         * 3.Convert stream into map
         * case i.Collectors.toMap()
         */
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee(1, "A", 100),
                new Employee(2, "A", 200),
                new Employee(3, "B", 300),
                new Employee(4, "B", 400),
                new Employee(5, "C", 500),
                new Employee(6, "C", 600)));
        Map<Integer, Employee> employeesMap = employeeList.stream().collect(Collectors.toMap(Employee::getAge, Function.identity()));
        System.out.println(employeesMap);
        /**
         * case ii.Strem Elements with duplicate map keys
         * Collectors.groupingBy()
         * if stream elements have elements where map keys are duplicate
         * then we can user Map<String,List<Element>> format
         */

        Map<String, List<Employee>> stringListMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender));
        System.out.println(stringListMap);
    }
}
