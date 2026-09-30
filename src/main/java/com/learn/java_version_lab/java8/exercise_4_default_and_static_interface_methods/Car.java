package com.learn.java_version_lab.java8.exercise_4_default_and_static_interface_methods;

public class Car implements Vehicle{

    @Override
    public void accelerate() {
        System.out.println("override the accelerate method");
    }

    static void main() {
        Vehicle vehicle = new Car();
        vehicle.accelerate();
        vehicle.applyBreak();
    }
}
