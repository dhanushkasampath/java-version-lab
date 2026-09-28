package com.learn.java_version_lab;

import com.learn.java_version_lab.java8.exercise_1_replace_anonymouse_classes_with_lambdas.Employee;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static <T> void printList(List<T> items){
        items.stream()
                .map(item -> {
                    System.out.println(item);
                    return item;
                })
                .toList();
        System.out.println("================================");
    }

    public static List<Employee> getEmployees(){
        return Arrays.asList(
                new Employee(1L, "Dhanushka", "IT", 150000),
                new Employee(2L, "John", "HR", 90000),
                new Employee(3L, "Peter", "IT", 120000),
                new Employee(4L, "Sarah", "Finance", 130000),
                new Employee(6L, "David", "IT", 80000),
                new Employee(7L, "Sam", "HR", 30000),
                new Employee(8L, "Aravind", "Finance", 10000),
                new Employee(9L, "Ranjan", "IT", 660000),
                new Employee(10L, "Gosh", "HR", 70000)
        );
    }
}
