package com.learn.java_version_lab.java16.exercise_14_records.example2_immutability;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    static void main() {
        /*
            Important: Records are shallowly immutable, not necessarily deeply immutable.
            If a record contains a mutable object such as a List, that list can still be changed
            unless you protect it.
        */
        List<String> membersList = new ArrayList<>();
        membersList.add("David");

        JavaRecordWay2 javaRecordWay2 = new JavaRecordWay2(membersList);//creation of the record

        System.out.println(javaRecordWay2.members());

        membersList.add("Peter");
        System.out.println(javaRecordWay2.members());
    }
}
