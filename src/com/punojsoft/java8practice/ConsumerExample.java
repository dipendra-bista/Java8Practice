package com.punojsoft.java8practice;

import java.util.function.Consumer;

/**
 * it if functional interface which takes input and return
 * nothing
 */
public class ConsumerExample {
    public static void main(String[] args) {
        GreetingService greetingService = msg -> System.out.println(msg + "dipendra");
        greetingService.greeting("Hi ..");

        Consumer<String> greetingConsumer = s -> System.out.println(s + " Parisha!");
//        greetingConsumer.accept("Hello...");

        greetingConsumer.andThen((msg) -> greetingService.greeting(msg)).accept("Namaste ...");

    }

    interface GreetingService {
        void greeting(String msg);
    }
}
