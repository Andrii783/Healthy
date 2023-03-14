package com.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Client extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_address_fk_id")
    private Address address;

    public Client() {
    }

    public Client(String lastName, String firstName, String patronymic,
                  String phone, Gender gender, LocalDate dateOfBirth, String email) {
        super(lastName, firstName, patronymic, phone, gender, dateOfBirth, email);

    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


