package com;

import com.configuration.ConfigApp;
import com.domain.*;
import com.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestMedicine {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        AddressService service = context.getBean(AddressService.class);

        System.out.println();

       // ClientService clientService = context.getBean(ClientService.class);
       // ClientService = clientService;


        ClientService clientService = context.getBean(ClientService.class);

        DoctorService doctorService = context.getBean(DoctorService.class);
        TicketService ticketService = context.getBean(TicketService.class);
           DoctorService service_doc = context.getBean(DoctorService.class);
        HistoryService historyService = context.getBean(HistoryService.class);
           //ClientService com.service = new ClientService();

        Address address = new Address("Nezalegnosti", 27, 24, false, City.KIEV);

        Client client = new Client("Palko", "Andrii", "Volodimirovich",
                "12", Gender.MAN, LocalDate.of(1983, 1, 7),
                "okna-83@mail.ru");

        Ticket ticket = new Ticket(LocalDateTime.now(), Polyclinic.HOSPITAL, 23,
                true, Service.CONSULTATION);

        Doctor doctor = new Doctor("Ivanov", "Petro", "Ivanovich",
                "34", Gender.MAN,
                LocalDate.of(1985,1,1), Category.CATEGORY_1,
                Profile.DENTIST, "LegionPalko@gmail.com");

        Doctor doctor1 = doctorService.getById(4);

        doctor.addTicket(ticket);

        History history = new History(doctor, "delete tooth");
        historyService.save(history);
       // client.addHistory(history);
       // ticket.setDoctor(doctor);
       // address.setClient(client);
        client.setAddress(address);
        clientService.save(client);
        doctorService.save(doctor);
        //doctorService.removeById z(doctor);    */
System.out.print("select * from client");
    }
}
