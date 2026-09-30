package com.learn.java_version_lab.java8.exercise_3_optional;


import com.learn.java_version_lab.Employee;
import com.learn.java_version_lab.Utils;

import java.util.List;
import java.util.Optional;

public class Test {
    static void main() {
        Optional<Employee> employee = findEmployee(5L);
        System.out.println(employee);

        /*
            Now suppose we want a default employee if the employee doesn't exit
         */
        Employee employee1 = findEmployee(4L).orElse(new Employee(0L, "unknown", "unknown", 0));

        /*
            orElseGet
         */
        //        Employee employee1 = findEmployee(4L).orElse(log()); IMPORTANT: orElse() always evaluate its argument. that is way orElseGet() is useful which executed only when the Optional is empty
        System.out.println(employee1);

    }

    static Optional<Employee> findEmployee(Long id){
        List<Employee> employeeList = Utils.getEmployees();

        return employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();// findFirst returns Optional<Employee> rather than returning null if there is no employee with given id
    }

    static Employee log(){
        System.out.println("this got evaluated");
        return new Employee(0L, "unknown", "unknown", 0);
    }
}
