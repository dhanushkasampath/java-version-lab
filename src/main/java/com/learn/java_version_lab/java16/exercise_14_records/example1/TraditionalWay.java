package com.learn.java_version_lab.java16.exercise_14_records.example1;

public class TraditionalWay {

    private final Long id;
    private final String name;
    private final String email;

    public TraditionalWay(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // equals(), hashCode(), toString()
}