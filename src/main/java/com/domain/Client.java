package com.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    private String patronymic;

    private int phone;

    @Enumerated (EnumType.ORDINAL)
    private Gender gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    private String email;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "client_address_fk_id")
    private Address address;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "client_history",
    joinColumns = @JoinColumn(name = "client_id"),
    inverseJoinColumns = @JoinColumn(name = "history_id"))
    private List<History> histories = new ArrayList<>();

    public Client(String lastName, String firstName, String patronymic,
                  int phone, Gender gender, LocalDate dateOfBirth,
                  String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public Client() {
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getPatronymic() {return patronymic;}

    public void setPatronymic(String patronymic) {this.patronymic = patronymic;}

    public int getPhone() {return phone;}

    public void setPhone(int phone) {this.phone = phone;}

    public Gender getGender() {return gender;}

    public void setGender(Gender gender) {this.gender = gender;}

    public LocalDate getDateOfBirth() {return dateOfBirth;}

    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}


    public void setAddress(Address address) {this.address = address;}

    public void setHistories(List<History> histories) {this.histories = histories;}


    //add 25.08.2018
    public void addHistory (History history) { histories.add(history); }

}



