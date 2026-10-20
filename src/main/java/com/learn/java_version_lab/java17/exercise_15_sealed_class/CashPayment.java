package com.learn.java_version_lab.java17.exercise_15_sealed_class;

/*
    Notice that all three classes are declared final. This means no other class can extend them.
 */
public final class CashPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using cash");
    }
}
