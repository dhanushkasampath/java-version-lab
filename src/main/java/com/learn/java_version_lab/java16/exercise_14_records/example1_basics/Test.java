package com.learn.java_version_lab.java16.exercise_14_records.example1_basics;

public class Test {
    static void main() {
        JavaRecordWay javaRecordWay = new JavaRecordWay(1L, "Dhanushka", "abc@gmail.com");

        /*
            Notice that record accessors use id() and name(), not getId() and getName().
        */
        System.out.println(javaRecordWay.id());
        System.out.println(javaRecordWay.name());
        System.out.println(javaRecordWay.email());

        System.out.println(javaRecordWay);
    }
}
