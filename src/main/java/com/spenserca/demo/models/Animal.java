package com.spenserca.demo.models;

public class Animal {
    private String name;
    private String description;
    private String funFact;

    public Animal(
            String name,
            String description,
            String funFact
    ) {
        this.name = name;
        this.description = description;
        this.funFact = funFact;
    }

    @Override
    public String toString() {
        return "I'm a " + name + ".";
    }
}
