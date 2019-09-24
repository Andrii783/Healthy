package com.service;

import com.domain.Ticket;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class TicketService implements AbstractService <Ticket>{

  //  @PersistenceUnit
  //  private EntityManagerFactory factory;

    @PersistenceContext
    private EntityManager em;

    public void save(Ticket ticket) {

        em.persist(ticket);

    }

    @Override
    public void removeById(int id) {
        Ticket removeTicket = em.getReference(Ticket.class, id);
        em.remove(removeTicket);
    }

    @Override
    public void update(Ticket ticket) {
        Ticket mergedTicket = em.merge(ticket);
        em.persist(mergedTicket);
    }


}
