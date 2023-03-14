package com.domain;

import javax.persistence.*;


@Entity


public class Address {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private int id;

    private String street;

    private int build;

    private int appartment;

    @Column(name = "private_sector")
    private boolean isPrivateSector;

    //25.08.2018
    @Enumerated(EnumType.STRING)
    private City city;

    //25.08.2018
    @OneToOne(mappedBy = "address")
    private Client client;

    public Address(String street, int build, int appartment, boolean isPrivateSector, City city) {
        this.street = street;
        this.build = build;
        this.appartment = appartment;
        this.isPrivateSector = isPrivateSector;
        this.city = city;
    }

    public Address() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuild() {
        return build;
    }

    public void setBuild(int build) {
        this.build = build;
    }

    public int getAppartment() {
        return appartment;
    }

    public void setAppartment(int appartment) {
        this.appartment = appartment;
    }

    public boolean isPrivateSector() {
        return isPrivateSector;
    }

    public void setPrivateSector(boolean privateSector) {
        isPrivateSector = privateSector;
    }
}
