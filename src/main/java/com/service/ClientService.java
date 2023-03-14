package com.service;

import com.dao.ClientDAO;
import com.domain.Client;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;

@Service
@Transactional
public class ClientService implements AbstractService<Client> {

    private final ClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @PersistenceUnit
    private EntityManagerFactory factory;

    /*public void saveFactory(Client client) {
        EntityManager em = factory.createEntityManager();

        EntityTransaction tran = em.getTransaction();

        tran.begin();

        em.persist(client);

        tran.commit();
    }*/


    public void save(Client client) {
        clientDAO.save(client);
    }

    public void removeById(int id) {
        clientDAO.removeById(id);
    }

    public void update(Client client) {

        clientDAO.update(client);
    }

    @Override
    public Client getById(int id) {

        return clientDAO.getById(id);
    }
}
