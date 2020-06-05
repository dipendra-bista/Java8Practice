package com.punojsoft.java8practice;

import model.Employee;

import java.util.*;
import java.util.function.Consumer;

/**
 * used when we want to sort collection of objects
 */
public class ComparatorExample {
    public static void main(String[] args) {
        List<Employee> employees = getEmployees();
//        sort all employee by firstName
        employees.sort(Comparator.comparing(e -> e.getFirstName()));
        //or
        employees.sort(Comparator.comparing(Employee::getFirstName));

        Consumer<List<Employee>> printEmployee = employees1 -> {
            employees1.forEach(System.out::println);
        };
        printEmployee.accept(employees);
        /**
         * Sortbyfirstname reverse order
         *
         */
        Comparator<Employee> comparator = Comparator.comparing(e -> e.getFirstName());
        employees.sort(comparator.reversed());

        /**
         * sorting based on multiple fields
         * it will first sort according to firstname and then lastname
         */

        Comparator<Employee> groupByComparator = Comparator
                .comparing(Employee::getFirstName)
                .thenComparing(Employee::getLastName);

        employees.sort(groupByComparator);
    }

    private static List<Employee> getEmployees() {
        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");
        return new ArrayList<Employee>(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10));
    }
}
