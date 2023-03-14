package com.dao;

import com.domain.Ticket;

public interface TicketDAO {
    void save(Ticket ticket);
    void update(Ticket ticket);
    void removeById(int id);
    Ticket getById(int id);
}
