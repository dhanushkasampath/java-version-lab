package com.learn.java_version_lab.java8.exercise_3_optional;

import com.learn.java_version_lab.Employee;

import java.util.Optional;

import static com.learn.java_version_lab.java8.exercise_3_optional.Test.findEmployee;

/*
    This is similar to Stream's filter(). Bure here were are filtering the value inside an Optional.
 */
public class Test3 {
    static void main() {
        /*
            Suppose you only want the employee if their salary is greater than 100,000
         */
        Optional<Employee> highlyPaidEmployee = findEmployee(4L).filter(employee -> employee.getSalary() > 100000);
        System.out.println(highlyPaidEmployee);

        /*
            Employee will not be returned as his salary is not greater than 100,000
         */
        Optional<Employee> highlyPaidEmployee2 = findEmployee(2L).filter(employee -> employee.getSalary() > 100000);
        System.out.println(highlyPaidEmployee2);
    }
}
