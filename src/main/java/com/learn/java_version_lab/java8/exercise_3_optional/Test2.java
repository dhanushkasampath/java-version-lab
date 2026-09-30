package com.learn.java_version_lab.java8.exercise_3_optional;

import com.learn.java_version_lab.Employee;

import java.util.Optional;

import static com.learn.java_version_lab.java8.exercise_3_optional.Test.findEmployee;

public class Test2 {
    static void main() {
        /*
            Now lets say an Employee must exist and application can not proceed without that. then we can use orElseThrow

            before java 8.
            Employee employee = findEmployee(100L);

            if (employee == null) {
                throw new RuntimeException("Employee not found");
            }
         */
        //After java 8.
        //Employee employee = findEmployee(100L)
        Employee employee = findEmployee(4L)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found: " + 100L)
                );
        System.out.println(employee);

        /*
            Now lets say you want the employee's name.

            before java 8
            Employee employee = findEmployee(4L);

            if (employee != null) {
                String name = employee.getName();
            }
         */
        //After java 8
        Optional<String> name =
                findEmployee(4L)
                        .map(Employee::getName);
        System.out.println(name);

    }
}
