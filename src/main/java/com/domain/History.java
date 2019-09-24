package com.domain;

import javax.persistence.*;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "history_id")
    private int id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "history_doctor_fk_id")
    private Doctor doctor;

    private String result;


    public History(Doctor doctor, String result) {
        this.doctor = doctor;
        this.result = result;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public Doctor getDoctor() {return doctor;}

    public void setDoctor(Doctor doctor) {this.doctor = doctor;}

    public String getResult() {return result;}

    public void setResult(String result) {this.result = result;}
}
