package com.learn.java_version_lab.java16.exercise_12_pattern_matching_for_instanceof;

class Payment {
    public void process() {
        System.out.println("Processing general payment");
    }
}

class CardPayment extends Payment {
    public void process() {
        System.out.println("Processing card payment");
    }

    public void payWithCard() {
        System.out.println("Paying with card details");
    }
}

class CashPayment extends Payment {
    public void process() {
        System.out.println("Processing cash payment");
    }
}

/*
    There are two steps in the old approach:

    1. payment instanceof CardPayment checks whether the object is a CardPayment.
    2. (CardPayment) payment casts the reference to CardPayment.

    The cast is redundant after a successful type check, provided you haven't changed
    the reference between the check and the cast.
*/
public class OldApproach {
    public static void main(String[] args) {

        Payment payment = new CardPayment();

        if (payment instanceof CardPayment) {
            CardPayment card = (CardPayment) payment;
            card.process();
            card.payWithCard();
        }
    }
}
