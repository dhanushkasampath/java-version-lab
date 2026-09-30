package com.learn.java_version_lab.java8.exercise_1_replace_anonymouse_classes_with_lambdas.filtering;

import com.learn.java_version_lab.Employee;

import java.util.ArrayList;
import java.util.List;

import static com.learn.java_version_lab.Utils.getEmployees;
import static com.learn.java_version_lab.Utils.printList;

public class Test {
    static void main() {
        List<Employee> employees = getEmployees();
        printList(employees);

        /**
            Suppose we want to find employees whose salary is greater than 100,000
            java 7 style
            This is perfectly valid.
            But Java 8 introduced the Stream API, allowing us to express the operation differently.
        **/
        List<Employee> result = new ArrayList<>();
        for(Employee employee: employees){
            if(employee.getSalary() > 100000){
                result.add(employee);
            }
        }
        printList(result);

        /**
           Filtering using java 8 stream + lambda
        */
        List<Employee> filteredList = employees.stream()
                .filter(employee -> employee.getSalary() > 100000)
                .toList();
        printList(filteredList);
    }
}
