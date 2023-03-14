package com.dao;

import com.domain.Address;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

@Repository
@Transactional
public class MySQLAddressDAO implements AddressDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Address address) {
        em.persist(address);
    }

    @Override
    public void removeById(int id) {
//2 запроса
        /*Address removeAddress = em.getReference(Address.class, id);
        em.remove(removeAddress);*/

         //1 запрос
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaDelete<Address> criteriaDelete = builder.createCriteriaDelete(Address.class);

        Root<Address> root = criteriaDelete.from(Address.class);

        Path<Object> path = root.get("id");

        criteriaDelete.where(builder.equal(path, id));

        em.createQuery(criteriaDelete).executeUpdate();
    }

    @Override
    public void update(Address address) {
        Address mergedAddress = em.merge(address);
        em.persist(mergedAddress);
    }

    @Override
    public Address getById(int id) {
        return em.find(Address.class, id);
    }
}
