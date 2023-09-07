package com.graphql.model;

public class Director {

    private Integer id;
    private String firstName;
    private String lastName;

    public Director(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }
}
