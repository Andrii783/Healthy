package com.service;

import com.domain.History;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class HistoryService implements AbstractService <History>{

 //   @PersistenceUnit
 //   private EntityManagerFactory factory;

    @PersistenceContext
    private EntityManager em;

    public void save(History history) {

        em.persist(history);

    }

    @Override
    public void removeById(int id) {
        History removeHistory = em.getReference(History.class, id);
        em.remove(removeHistory);
    }

    @Override
    public void update(History history) {
        History mergedHistory = em.merge(history);
        em.persist(mergedHistory);
    }


}
