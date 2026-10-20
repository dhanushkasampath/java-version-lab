package com.learn.java_version_lab.java16.exercise_14_records.example1_basics;

public record JavaRecordWay(
        Long id,
        String name,
        String email
) {}

/*

The compiler automatically generates:
    - A field for each component.
    - A canonical constructor.
    - Accessor methods.
    - equals().
    - hashCode().
    - toString().
 */