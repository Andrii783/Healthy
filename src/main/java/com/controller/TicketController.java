package com.controller;

import com.domain.History;
import com.domain.Ticket;
import com.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;

@Controller
@RequestMapping("ticket")
public class TicketController {
    private final TicketService ticketService;
    private Ticket ticket;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(value = "/test-ticket", method = RequestMethod.GET)
    @ResponseBody
    public String test() {//localhost:9999/my/healthy/testHealthy
        return "Test, Ticket!!!";
    }

    @PostMapping("/ticket")
    public void save(@RequestBody Ticket ticket) {
        ticketService.save(ticket);
    }

    @DeleteMapping("/ticket/{id}")
    public void removeById(@PathVariable("id") int id) {
        ticketService.removeById(id);
    }

    @PutMapping("/ticket")
    public void update(@RequestBody Ticket ticket) {
        ticketService.update(ticket);
    }

    @GetMapping("/ticket")
    public Ticket getById(@PathVariable("id") int id) {
        Ticket ticket = null;

        try {
            ticket = ticketService.getById(id);
        } catch (NoResultException e) {
            throw new IllegalArgumentException("Man " + " with id " + id + " not found ");
        }

        return ticket;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> handlerTicket(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
