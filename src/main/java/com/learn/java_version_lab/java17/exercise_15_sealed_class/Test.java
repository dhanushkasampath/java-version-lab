package com.learn.java_version_lab.java17.exercise_15_sealed_class;

public class Test {
    public static void main(String[] args) {

        Payment payment1 = new CardPayment();
        Payment payment2 = new CashPayment();
        Payment payment3 = new BankTransfer();

        payment1.pay(5000);
        payment2.pay(1500);
        payment3.pay(10000);
    }
}
