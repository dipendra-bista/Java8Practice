package com.punojsoft.java8practice;

import java.util.Date;
import java.util.function.Supplier;

/**
 * supplier doesn't take anything but return something
 */
public class SupplierExample {
    public static void main(String[] args) {
        //without supplier
        DateService dateService = () -> new Date();
        System.out.println(dateService.getCurrentDate());

        //by using supplier
        Supplier<Date> stringSupplier = () -> new Date();
        System.out.println(stringSupplier.get());
    }

    @FunctionalInterface
    interface DateService {
        Date getCurrentDate();
    }
}
