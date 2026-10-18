package com.learn.java_version_lab.java14.exercise_11_NPE_enhancement;

class City{
    private String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Address{
    private City city;

    public Address(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }
}

public class Test {
    public static void main(String[] args) {
        Address address = new Address(null);
//        Address address = new Address(new City("Colombo"));

        String cityName = address.getCity().getName();
        System.out.println(cityName);
    }
}
