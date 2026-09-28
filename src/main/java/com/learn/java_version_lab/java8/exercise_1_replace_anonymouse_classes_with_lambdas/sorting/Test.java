package com.learn.java_version_lab.java8.exercise_1_replace_anonymouse_classes_with_lambdas.sorting;

import com.learn.java_version_lab.java8.exercise_1_replace_anonymouse_classes_with_lambdas.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.learn.java_version_lab.Utils.getEmployees;
import static com.learn.java_version_lab.Utils.printList;

public class Test {
    static void main() {
        List<Employee> employees = getEmployees();
        printList(employees);

        /**
             suppose we want to sort employees by salary
             java 7 style - before java 8 we would commonly write an anonymous class.
             this is called anonymous class
         */
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        });
        printList(employees);

        //java 8 lambda
        employees.sort(
                (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())
        );
        printList(employees);

        //java 8 method reference
        employees.sort(
                Comparator.comparing(Employee::getSalary)
        );
        printList(employees);
    }
}
