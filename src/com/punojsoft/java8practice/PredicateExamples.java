package com.punojsoft.java8practice;

import model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * i.the only advantage of using predicate is
 * it will help us to move all the employee related to predicate to one place
 * ii.any change need not be duplicated into multiple times
 */
class EmployeePredicates {
    public static Predicate<Employee> isAdultMale() {
        return employee -> employee.getGender() == "M" && employee.getAge() > 21;
    }

    public static Predicate<Employee> isAgeMoreThan(Integer age) {
        return employee -> employee.getAge() > age;
    }

    /**
     * stream ko filter method le pani predicate as input linxa
     *
     * @param emps
     * @param predicate
     * @return
     */
    public static List<Employee> filterEmployees(List<Employee> emps, Predicate<Employee> predicate) {
        return emps.stream().filter(predicate).collect(Collectors.toList());
    }
}

/**
 * Predicate is functional interface and can therefore be used as the assignment
 * target for a lamda expression or method reference.
 * colllection/group of similar object jasma chai certain condition
 * lagaunuxa jasle either true or false return garos
 */
public class PredicateExamples {

    public static void main(String[] args) {
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

        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e1, e2, e3, e4, e5, e6, e7, e8, e9, e10}));

        EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultMale()).forEach(System.out::println);

        Consumer<String> greeting = s -> {
            System.out.println(s);
        };

        Supplier<Date> supplier = () -> new Date();
        System.out.println(supplier.get());

        greeting.accept("hello dipendra!");
        /**
         * consumer(input linxa tara return gardaina)
         * supplier(input lidaina tara return chai garxa)
         * predicate(input linxa ra true false return garxa)
         */
        int age = 20;
        Predicate<Integer> isAdult = a -> a > 18;
        if (isAdult.test(age)) {
            Consumer<String> message = m -> {
                System.out.println(m + " :" + age);
            };
            message.accept("your age is ");
        }
    }

    public static void greeting(String greeting) {
        System.out.println(greeting);
    }
}
