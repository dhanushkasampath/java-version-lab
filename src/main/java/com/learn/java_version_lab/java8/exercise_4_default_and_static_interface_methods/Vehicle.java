package com.learn.java_version_lab.java8.exercise_4_default_and_static_interface_methods;

interface Vehicle {
    default void accelerate(){
        System.out.println("inside accelerate method");
    }

    default void applyBreak(){
        System.out.println("inside applyBreak method: " + getSquare(2));
    }

    /*
        Static method act as a supportive method for default methods
     */
    static int getSquare(int x){
        return x*x;
    }
}
