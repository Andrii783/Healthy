package com.dao;

import com.domain.Address;

public interface AddressDAO {
    void save(Address address);
    void update(Address address);
    void removeById(int id);
    Address getById(int id);
}
