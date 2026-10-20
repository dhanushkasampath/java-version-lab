package com.learn.java_version_lab.java16.exercise_14_records.example3_constructors;

/*
    Java records support three important constructor patterns.
 */

/*
    A. Canonical constructor
        The canonical constructor accepts all record components.
 */
record CustomerResponse1(
        Long id,
        String name,
        String email
) {
    public CustomerResponse1(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

/*
    B. Compact constructor
        A compact constructor is useful for validation and normalization.
 */
record CustomerResponse2(
        Long id,
        String name,
        String email
) {
    public CustomerResponse2 {
        name = name.trim(); // normalize the data
        email = email.trim(); // normalize the data
    }
}

/*
    C. Additional constructor
        An additional constructor must delegate to another constructor using this(...) as its first statement.
 */
record CustomerResponse3(
        Long id,
        String name,
        String email
) {
    public CustomerResponse3(Long id, String name) {
        this(id, name, "unknown@example.com");
    }
}

public class Test {
    static void main() {

        System.out.println("=========usage of B. Compact constructor==========");
        CustomerResponse2 customerResponse2 = new CustomerResponse2(1L, "   Dhanushka  ", "   abc@gmail.com  ");

        System.out.println(customerResponse2.name()); // prints "Dhanushka" after removing white spaces using trim.
        System.out.println(customerResponse2.email()); // prints "abc@gmail.com" after removing white spaces using trim.

        System.out.println("=========usage of C. Additional constructor======");
        CustomerResponse3 customerResponse3 = new CustomerResponse3(1L, "John");

        System.out.println(customerResponse3.email());//here default value is used for email.
    }
}
