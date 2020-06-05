package com.punojsoft.java8practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 10, 8, 3, 4, 5, 6);
        Consumer<Integer> action = System.out::println;
        List<Integer> list = numbers.stream().filter(number -> number % 2 == 0).
                map(integer -> integer * 10).collect(Collectors.toList());
        list.forEach(action);
        System.out.println(list.stream().reduce((integer, integer2) -> integer + integer2).get());
        /**
         * intermediate operation
         */
        //filter,sorted,map
        /**
         * terminal operation
         */
        //forEach,Collect,match,count,reduce
        /**
         * short circuit operations
         * yadi kunai conditiona match vayo vane matra run gar vanna lai pani
         * all collection ma check garxa tara condition satisfied vayepaxi further chack nagaar
         * vannalai
         *
         */
    }//anyMatch,finadFirst
}
