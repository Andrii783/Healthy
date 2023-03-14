package com.service;

import com.dao.DoctorDAO;
import com.domain.Doctor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Service
@Transactional
public class DoctorService implements AbstractService<Doctor> {

    private final DoctorDAO doctorDAO;

    public DoctorService(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

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
        doctorDAO.save(doctor);
    }

    public void removeById(int id) {
        doctorDAO.removeById(id);
    }

    public void update(Doctor doctor) {
        doctorDAO.update(doctor);
    }

    @Override
    public Doctor getById(int id) {
        return doctorDAO.getById(id);
    }

}

