package com.service;

import com.domain.Doctor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Service
@Transactional
public class DoctorService implements AbstractService<Doctor> {

    @PersistenceUnit
    private EntityManagerFactory factory;

    @PersistenceContext
    private EntityManager em;

    public void saveFactory(Doctor doctor) {
        EntityManager em = factory.createEntityManager();

        EntityTransaction tran = em.getTransaction();

        tran.begin();

        em.persist(doctor);

        tran.commit();
    }

    public void save(Doctor doctor) {
        em.persist(doctor);
    }


    public void removeById(int id) {
        Doctor removeDoc = em.getReference(Doctor.class, id);
        em.remove(removeDoc);

        /*Query query = em.createQuery("DELETE FROM Doctor d WHERE d.id = :tempId");

        query.setParameter("tempId", id);

        query.executeUpdate();*/

    }

    public void update(Doctor doctor) {
        Doctor mergedDoctor = em.merge(doctor);
        em.persist(mergedDoctor);
    }

}

