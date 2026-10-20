package com.learn.java_version_lab.java16.exercise_14_records.example6_nested_records;

/*
    A record can contain another record as a component. This is useful for representing nested API response data.
    For example, a customer response containing an address:
 */
record AddressResponse(
        String city,
        String country
){}

record CustomerResponse(
        Long id,
        String name,
        String email,
        AddressResponse address
){}

public class Test {
    static void main() {
        AddressResponse address = new AddressResponse("Colombo", "Sri Lanka");

        CustomerResponse customer = new CustomerResponse(1L, "Dhanushka", "abc@gmail.com", address);

        System.out.println(customer.address().city());
        System.out.println(customer.address().city());
    }
}
