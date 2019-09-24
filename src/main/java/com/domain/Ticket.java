package com.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private int id;

    @Column(name = "ticket_date")
    private LocalDateTime ticketDate;

    @ManyToOne
    @JoinColumn (name = "ticket_doctor_fk_id")
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    private Polyclinic polyclinic;

    @Column(name = "cabinet_number")
    private int cabinetNumber;

    private boolean free;

    @Enumerated(EnumType.STRING)
    private Service service;

    public Ticket(LocalDateTime ticketDate, Polyclinic polyclinic,
                  int cabinetNumber, boolean free, Service service) {
        this.ticketDate = ticketDate;
        this.polyclinic = polyclinic;
        this.cabinetNumber = cabinetNumber;
        this.free = free;
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

    public boolean isFree() {return free;}

    public void setFree(boolean free) {this.free = free;}

    public Service getService() {return service;}

    public void setService(Service service) {this.service = service;}
}
