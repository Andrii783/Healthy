package com.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm a", shape = JsonFormat.Shape.STRING)//2020-12-03 05:13 PM
    @Column(name = "ticket_date")
    private LocalDateTime ticketDate;

    @ManyToOne
    @JoinColumn (name = "ticket_doctor_fk_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "client_fk_id")
    private Client client;

    @Enumerated(EnumType.STRING)
    private Polyclinic polyclinic;

    @Column(name = "cabinet_number")
    private int cabinetNumber;

    @JsonProperty("free")
    private boolean isFree;

    @Enumerated(EnumType.STRING)
    private Service service;

    public Ticket(LocalDateTime ticketDate, Polyclinic polyclinic,
                  int cabinetNumber, boolean isFree, Service service) {
        this.ticketDate = ticketDate;
        this.polyclinic = polyclinic;
        this.cabinetNumber = cabinetNumber;
        this.isFree = isFree;
        this.service = service;
    }

    public Ticket() {
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public LocalDateTime getTicketDate() {return ticketDate;}

    public void setTicketDate(LocalDateTime ticketDate) {this.ticketDate = ticketDate;}

    public Doctor getDoctor() {return doctor;}

    public void setDoctor(Doctor doctor) {this.doctor = doctor;}

    public Polyclinic getPolyclinic() {return polyclinic;}

    public void setPolyclinic(Polyclinic polyclinic) {this.polyclinic = polyclinic;}

    public int getCabinetNumber() {return cabinetNumber;}

    public void setCabinetNumber(int cabinetNumber) {this.cabinetNumber = cabinetNumber;}

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Service getService() {return service;}

    public void setService(Service service) {this.service = service;}
}
