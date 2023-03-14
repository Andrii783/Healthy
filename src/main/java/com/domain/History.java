package com.domain;

import javax.persistence.*;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "history_id")
    private int id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "history_doctor_fk_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "client_fk_id")
    private Client client;

    private String result;

    public History(){

    }

    public History(Doctor doctor, String result) {
        this.doctor = doctor;
        this.result = result;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public Doctor getDoctor() {return doctor;}

    public void setDoctor(Doctor doctor) {this.doctor = doctor;}

    public String getResult() {return result;}

    public void setResult(String result) {this.result = result;}
}
