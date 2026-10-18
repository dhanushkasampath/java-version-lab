package com.learn.java_version_lab.java14.exercise_10_switch_expressions;

/*
    This works, but it requires extra code.
    This is called switch statement
    This performs actions. It does not produce a value itself
 */
public class TraditionalSwitch {

    enum Status {
        CREATED,
        PAID,
        CANCELLED,
        REFUNDED
    }

    public static void main(String[] args) {

        Status status = Status.PAID;

        String result;

        // Traditional switch statement
        switch (status) {
            case CREATED:
                result = "Created";
                break;

            case PAID:
                result = "Paid";
                break;

            case CANCELLED:
                result = "Cancelled";
                break;

            default:
                result = "Unknown";
        }

        System.out.println(result);
    }
}
