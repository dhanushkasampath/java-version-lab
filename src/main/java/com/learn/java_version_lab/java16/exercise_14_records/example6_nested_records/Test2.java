package com.learn.java_version_lab.java16.exercise_14_records.example6_nested_records;

/*
    Records can also be declared inside other classes:
    To use it from another class, reference it through its enclosing class(Test2):
 */
public class Test2 {
    public record CustomerSummary( // here CustomerSummary is a nested record
            Long id,
            String name
    ){}

    static void main() {
        CustomerSummary customerSummary = new CustomerSummary(1L, "Dhanushka");
        System.out.println(customerSummary.id());
        System.out.println(customerSummary.name());
    }

}
