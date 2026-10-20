package com.learn.java_version_lab.java16.exercise_14_records.example2_immutability;

import com.learn.java_version_lab.java16.exercise_14_records.example1.JavaRecordWay;

public class Test {
    JavaRecordWay javaRecordWay =
            new JavaRecordWay(1L, "John", "john@example.com");

    /*
        Record components are implicitly private final.
        You cannot reassign them after construction.
    */
//    javaRecordWay.name = "Peter";// Compilation error

    /*
        To change the name, create a new record:
     */
    JavaRecordWay javaRecordWay2 =
            new JavaRecordWay(javaRecordWay.id(), "Peter", javaRecordWay.email());

}
