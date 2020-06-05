package com.punojsoft.java8practice;

import model.Employee;

import java.util.Optional;

/**
 * speciall used to avoid nullpointer exception
 */
public class OptionalPracticeexample {
    public static void main(String[] args) {
        /**
         * preparing input
         */
        Employee employee = new Employee(1, 20, "M", "dipen", "Bista");
        Employee defaultEmployee = new Employee(1, 20, "M", "puja", "khadka");

        Optional<Integer> integerOptional = Optional.ofNullable(null);
        Optional<Employee> employeeOptional = Optional.ofNullable(null);

        System.out.println(employeeOptional.orElse(defaultEmployee).getLastName());
        employeeOptional.orElseGet(() -> defaultEmployee);

//        employeeOptional.orElseThrow();
//
//        if (employeeOptional.isPresent()) {
//            System.out.println(employeeOptional.get());
//        }
//        //        or
//        employeeOptional.ifPresent(employee1 -> System.out.println(employee1.getLastName()));
//
//        if (employeeOptional.isPresent()) {
//            System.out.println(employeeOptional.get());
//        } else {
//            System.out.println("Employee value is ot present!");
//        }
//        //          or
//        employeeOptional.ifPresentOrElse(employee1 -> System.out.println(employee1.getFirstName()), () -> System.out.println("Employee value is not present"));
    }
}
