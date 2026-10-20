package com.learn.java_version_lab.java16.exercise_14_records.example4_validations;

/*
    Records are excellent for validating DTOs and API response objects.

    For example, require a non-null ID and name, and a valid email format.
    Here you can see a compact constructor
 */
record CustomerResponse(
        Long id,
        String name,
        String email
) {
    public CustomerResponse {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(
                    "ID must be positive"
            );
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Name is required"
            );
        }

        if (email == null ||
                !email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new IllegalArgumentException(
                    "Invalid email address"
            );
        }

        name = name.trim();
        email = email.trim();
    }
}

public class Test {
    static void main() {
        //valid DTO object creation
        CustomerResponse customerResponse1 = new CustomerResponse(1L, "Dhanushka", "abc@gmail.com");
        System.out.println(customerResponse1.email());

        /*
            invalid DTO object creation

            The constructor throws an IllegalArgumentException because the name is invalid.
         */
        CustomerResponse customerResponse2 = new CustomerResponse(1L, "", "invlaid-email");

    }
}

/*
    The example above performs basic validation. For Spring Boot applications,
    you can also use Jakarta Bean Validation annotations such as @NotBlank, @NotNull,
    and @Email, provided the appropriate validation dependency is configured.
 */