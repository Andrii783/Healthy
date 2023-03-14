package com.dao;

import com.domain.Client;

public interface ClientDAO {
    void save(Client client);
    void update(Client client);
    void removeById(int id);
    Client getById(int id);
}
