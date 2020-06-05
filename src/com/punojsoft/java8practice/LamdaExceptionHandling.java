package com.punojsoft.java8practice;

import java.util.function.BiConsumer;

public class LamdaExceptionHandling {
    public static void main(String[] args) {

        int[] someNumbers = {1, 2, 3, 4};
        int key = 0;
        process(someNumbers, key, wrapperLamda((v, k) -> System.out.println(v / k)));
    }

    public static void process(int[] someInts, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : someInts) {
            consumer.accept(i, key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLamda(BiConsumer<Integer, Integer> consumer) {
//        return consumer;
//        return (v, k) -> System.out.println(v + k);
        return (v, k) -> {
//            System.out.println("executing from wrapper!");
            try {
                consumer.accept(v, k);
            } catch (ArithmeticException e) {
                System.out.println("Exception caught in wrapper lamda!");
            }
        };
    }

}
