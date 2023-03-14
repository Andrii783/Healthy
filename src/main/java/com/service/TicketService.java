package com.service;

import com.dao.TicketDAO;
import com.domain.Ticket;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Service
@Transactional
public class TicketService implements AbstractService <Ticket>{

  //  @PersistenceUnit
  //  private EntityManagerFactory factory;

    private final TicketDAO ticketDAO;

    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }
    @PersistenceUnit
    private EntityManagerFactory factory;
    @PersistenceContext
    private EntityManager em;



    public void save(Ticket ticket) {
        ticketDAO.save(ticket);
    }

    @Override
    public void removeById(int id) {
        ticketDAO.removeById(id);
    }


    public void update(Ticket ticket) {
        ticketDAO.update(ticket);
    }
    @Override
    public Ticket getById(int id) {
        return ticketDAO.getById(id);
    }
}
