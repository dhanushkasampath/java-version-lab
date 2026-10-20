package com.learn.java_version_lab.java16.exercise_14_records.example2_immutability;

import java.util.List;

public record JavaRecordWay2(List<String> members) {

    /*
        If this code segment added, the values in the initial list can not be changed after the record creation
     */
//    public JavaRecordWay2{
//        members = List.copyOf(members);
//    }
}
