package com.learn.java_version_lab.java16.exercise_13_pattern_matching_for_instanceof;

public class ModernApproach {
    public static void main(String[] args) {

        Payment payment1 = new CardPayment();
        Payment payment2 = new CashPayment();

        if (payment1 instanceof CardPayment card) {
            card.process();
            card.payWithCard();
        }

        if(payment2 instanceof CashPayment cash){
            cash.process();
        }
    }
}

/*
    - payment — the object being checked.
    - CardPayment — the type you expect.
    - card — a new variable that refers to the object as a CardPayment if the check succeeds.

    You no longer need to declare CardPayment card separately or perform an explicit cast.
 */