package com.punojsoft.java8practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Type inference is a feature of Java which provides ability
 * to compiler to look at each method invocation
 * and corresponding declaration to determine the type of arguments.
 */
public class TypeInferenceExample {
    public static void main(String[] args) {
        /**
         * java 7
         */
        List<Integer> list2 = new ArrayList<>();
        list2.add(12);
        showList(list2);

        /**
         * java 8 :we can call specialized method without
         * mentioning explicitly type of argument
         */
        showList(new ArrayList<>());

    }

    public static void showList(List<Integer> list) {
        if (!list.isEmpty())
            list.forEach(System.out::println);
        else
            System.out.println("list is empty!");
    }
}
