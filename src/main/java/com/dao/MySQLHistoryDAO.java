package com.dao;

import com.domain.History;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MySQLHistoryDAO implements HistoryDAO{
    @PersistenceContext
    private EntityManager em;

    public void save(History history) {
        em.persist(history);
    }

    @Override
    public void removeById(int id) {//criteria
        History removeHistory = em.getReference(History.class, id);
        em.remove(removeHistory);
    }

    @Override
    public void update(History history) {
        History mergedHistory = em.merge(history);
        em.persist(mergedHistory);
    }
    @Override
    public History getById(int id) {
        return em.find(History.class, id);
    }
}
