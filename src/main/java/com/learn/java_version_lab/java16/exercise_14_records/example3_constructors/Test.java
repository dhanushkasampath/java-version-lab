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
        name = name.trim();
        email = email.trim();
    }
}

public class Test {
}
