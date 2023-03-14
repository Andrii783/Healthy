package com.dao;

import com.domain.Address;
import com.domain.Client;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MySQLClientDAO implements ClientDAO{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Client client) {

        Address address = client.getAddress();

        address.setClient(client);

        em.persist(client);
    }

    @Override
    public void update(Client client) {
        Client mergedClient = em.merge(client);
        em.persist(mergedClient);
    }

    @Override
    public void removeById(int id) {
        Client removeClient = em.getReference(Client.class, id);
        em.remove(removeClient);

    }

    @Override
    public Client getById(int id) {

        return em.find(Client.class, id);
    }
}
