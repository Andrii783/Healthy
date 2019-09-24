package com.service;

import com.domain.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Service
@Transactional
public class ClientService implements AbstractService<Client> {

    @PersistenceUnit
    private EntityManagerFactory factory;

    @PersistenceContext
    private EntityManager em;

    public void saveFactory(Client client) {
        EntityManager em = factory.createEntityManager();

        EntityTransaction tran = em.getTransaction();

        tran.begin();

        em.persist(client);

        tran.commit();
    }

    public void save(Client client) {

        //Doctor doc = em.getReference(Doctor.class, 4);

       // em.removeById(doc);

        //em.persist(client);

        em.persist(client);

    }
    public void removeById(int id) {
        Client removeClient = em.getReference(Client.class, id);
        em.remove(removeClient);
    }

    public void update(Client client) {
        Client updateClient = em.getReference(Client.class, client.getId());
        em.remove(updateClient);
        em.persist(client);
    }
}
