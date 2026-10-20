package com.learn.java_version_lab.java17.exercise_15_sealed_class;

/*
    Sealed classes were introduced in Java 17 as a permanent feature.
    They allow you to control which classes or interfaces can extend or implement a type.
 */
public sealed interface Payment permits BankTransfer, CardPayment, CashPayment {
    void pay(double amount);
}

/*
    sealed — restricts which classes can implement Payment.(restrict further inheritance)
    permits — lists the allowed direct implementations.
    pay() — defines the common behavior for all payment types.
    final - stop inheritance. (No class can extend BankTransfer)
 */