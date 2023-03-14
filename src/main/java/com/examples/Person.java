package com.examples;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    @Enumerated(EnumType.ORDINAL)
    private NewGender gender;

    public Person(String firstName, NewGender gender) {
        this.firstName = firstName;
        this.gender = gender;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public NewGender getGender() {
        return gender;
    }

    public void setGender(NewGender gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

