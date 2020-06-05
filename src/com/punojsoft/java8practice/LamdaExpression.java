package com.punojsoft.java8practice;

import java.util.function.Predicate;

@FunctionalInterface
interface CalculatorService {
    Integer perform(Integer a, Integer b);

    default void doSomeThing() {
        System.out.println("this is default method!");
    }
}

public class LamdaExpression {


    public static void main(String[] args) {
        /**
         * lamda expressions are anonymous functions with no name and they passed
         * to other function as parameter.So,basically every lamda expression also must be
         * convertible to some type to be accepted
         * as method type.,Well that type in lamda expression are converted ,are always
         * of Functional interface
         */
//        simple lamda expression
        //(X+y)->x+y
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello from java!");
//            }
//        }).start();
//
//        new Thread(() -> {
//            System.out.println("hello from java8! lamda");
//        }).start();
//
        new Thread(LamdaExpression::doSomething).start();

//        CalculatorService multiplicationService = (a, b) -> {
//            return a * b;
//        };
//        System.out.println(multiplicationService.perform(10, 20));
        Predicate<String> status = s -> false;

    }

    public static void doSomething() {
        System.out.println("hello ");
    }
}
