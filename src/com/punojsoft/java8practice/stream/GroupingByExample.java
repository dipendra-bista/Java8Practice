package com.punojsoft.java8practice.stream;

import model.Item;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GroupingByExample {
    public static void main(String[] args) {
        /**
         *counting number of element
         */
        //3 apple, 2 banana, others 1
        Supplier<List<String>> items = () -> Arrays.asList("apple", "apple", "banana",
                "apple", "orange", "banana", "papaya");
        Map<String, Long> result = items.get()
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
        /**
         * adding sorting
         */
        Map<String, Long> finalMap = items.get().stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);

        /**
         * grouping by for list of objects
         */

        //3 apple, 2 banana, others 1
        List<Item> newItems = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
        Map<String, Long> stringLongMap = newItems.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
        System.out.println(stringLongMap);
    }

}
