package com;

import com.configuration.ConfigApp;
import com.domain.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.service.ClientService;
import com.service.DoctorService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestMedicine {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        ClientService clientService = context.getBean(ClientService.class);

        DoctorService doctorService = context.getBean(DoctorService.class);
        //   DoctorService service_doc = context.getBean(DoctorService.class)
//        ClientService com.service = new ClientService();

        Address address = new Address("Nezalegnosti", 27, 24, false, City.KIEV);

        Client client = new Client("Palko", "Andrii", "Volodimirovich",
                12, Gender.MAN, LocalDate.of(1983, 1, 7), "okna-83@mail.ru");

        Ticket ticket = new Ticket(LocalDateTime.now(), Polyclinic.Hospital, 23, true, Service.Consultation);

        Doctor doctor = new Doctor("Ivanov", "Petro", "Ivanovich", "34", Gender.MAN,
                "1980.02.10", Category.CATEGORY_1, Profile.Dentist);

        doctor.addTicket(ticket);

        History history = new History(doctor, "delete tooth");
        client.addHistory(history);
        ticket.setDoctor(doctor);
        address.setClient(client);
        client.setAddress(address);
        clientService.save(client);
//        doctorService.save(doctor);
        //doctorService.removeById (doctor);

    }
}
