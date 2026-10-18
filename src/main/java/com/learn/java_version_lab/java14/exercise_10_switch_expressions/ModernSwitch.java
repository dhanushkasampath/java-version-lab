package com.learn.java_version_lab.java14.exercise_10_switch_expressions;

/*
    This is called switch expression
    The arrow means that the matching case evaluates its right-hand side.
 */
public class ModernSwitch {

    enum Status {
        CREATED,
        PAID,
        CANCELLED,
        REFUNDED
    }

    static void main() {
        ModernSwitch.Status status = ModernSwitch.Status.PAID;

        String result = switch (status) {
            // Simple expression: no yield required
            case CREATED -> "Created";
            case PAID -> "Paid";
            case CANCELLED -> "Cancelled";
            default -> "Unknown";
        };

        System.out.println(result);

        //Use yield when a switch-expression branch has a block of statements and needs to produce a value.
        //===============================================

        String result2 = switch (status) {
            // Block with multiple statements: yield supplies the result
            case PAID -> {
                System.out.println("Processing payment...");
                yield "Paid";
            }
            default -> "Unknown";
        };

        System.out.println(result2);
    }
}
