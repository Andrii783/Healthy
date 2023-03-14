package com.dao;

import com.domain.Ticket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MySQLTicketDAO implements TicketDAO {
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
    @Override
    public Ticket getById(int id) {
        return em.find(Ticket.class, id);
    }
}
