package com.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Person {

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    private String patronymic;

    private String phone;

    @Enumerated (EnumType.ORDINAL)
    private Gender gender;

    @Column(name = "date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String email;

    public Person(String lastName, String firstName, String patronymic,
                  String phone, Gender gender, LocalDate dateOfBirth,
                  String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public Person() {
    }

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getPatronymic() {return patronymic;}

    public void setPatronymic(String patronymic) {this.patronymic = patronymic;}


    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public Gender getGender() {return gender;}

    public void setGender(Gender gender) {this.gender = gender;}

    public LocalDate getDateOfBirth() {return dateOfBirth;}

    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}

