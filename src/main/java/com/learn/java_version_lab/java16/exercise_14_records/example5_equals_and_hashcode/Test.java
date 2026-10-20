package com.learn.java_version_lab.java16.exercise_14_records.example5_equals_and_hashcode;

import java.util.HashSet;
import java.util.Set;

/*
    Records automatically compare their component values rather than object identity.
 */
record CustomerResponse(
        Long id,
        String name,
        String email
) {}

public class Test {
    static void main() {
        CustomerResponse customerResponse1 = new CustomerResponse(1L, "Dhanushka", "abc@gmail.com");
        CustomerResponse customerResponse2 = new CustomerResponse(1L, "Dhanushka", "abc@gmail.com");

        /*
            c1 == c2 checks whether both variables refer to the same object.
         */
        System.out.println(customerResponse1 == customerResponse2);// returns false

        /*
            c1.equals(c2) compares the record components values. in above, they are same
         */
        System.out.println(customerResponse1.equals(customerResponse2));// returns true

        /*
            Equal records must have equal hash codes.
         */
        System.out.println(customerResponse1.hashCode() == customerResponse2.hashCode());// returns true


        /*
            USAGE: Because the records have equal component values, the set treats them as the same logical element.
         */
        Set<CustomerResponse> customers = new HashSet<>();

        customers.add(customerResponse1);
        customers.add(customerResponse2);

        System.out.println(customers.size()); // here size become 1
    }
}
