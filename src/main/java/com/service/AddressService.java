package com.service;

import com.dao.AddressDAO;
import com.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

@Service
@Transactional
public class AddressService implements AbstractService<Address> {

    private final AddressDAO addressDAO;

    public AddressService(AddressDAO addressDAO) {

        this.addressDAO = addressDAO;
    }

    @Override
    public void save(Address address) {
        addressDAO.save(address);
    }

    @Override
    public void removeById(int id) {
        addressDAO.removeById(id);
    }

    @Override
    public void update(Address address) {
     addressDAO.update(address);
    }

    @Override
    public Address getById(int id) {
        return addressDAO.getById(id);
    }
}
