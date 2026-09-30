package com.learn.java_version_lab.java8.exercise_2_employee_analytics_with_streams;

import com.learn.java_version_lab.Utils;
import com.learn.java_version_lab.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    static void main() {
        List<Employee> employeeList = Utils.getEmployees();

        /**
            Find employees earning > 100,000
         */
        List<Employee> filtered = employeeList.stream()
                .filter(employee -> employee.getSalary() > 100000)
                .toList();
        Utils.printList(filtered);

        /**
            Find highest salary
         */
        employeeList.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.println("Highest Salary having employee: " + employeeList.get(0));

        /**
            Group employees by department.
            "partioningBy always return a boolean as the key. but groupingBy can have any number of keys"
         */
        Map<String, List<Employee>> employeesByDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("employeesByDepartment: " + employeesByDepartment);

        /**
            Calculate average salary
         */
        Double averageSalary = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("Average Salary: " + averageSalary);

        /**
            Find top 5 salaries
         */
        List<Double> salaryList = employeeList.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .toList();
        System.out.println("Top 5 salaries: " + salaryList);

        /**
            Count employees per department
         */
        Map<String, Long> employeesPerDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Employees per department: " + employeesPerDepartment);
    }
}
