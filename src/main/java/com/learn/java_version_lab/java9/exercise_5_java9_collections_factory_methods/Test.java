package com.learn.java_version_lab.java9.exercise_5_java9_collections_factory_methods;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Test {
    static void main() {
        /*
            Before java 9
         */
        List<String> names = Arrays.asList("Dhanushka", "John", "Peter", null);
//        names.add("test2");
        System.out.println(names);

        /*
            After java 9
         */
        List<String> names1 = List.of("Dhanushka", "John", "Peter");
//        names1.add("test");
        System.out.println(names1);

        Set<String> names2 = Set.of("Dhanushka", "John", "Peter");
//        names1.add("test");
        System.out.println(names2);
    }
}
