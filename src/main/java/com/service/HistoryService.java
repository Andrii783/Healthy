package com.service;

import com.dao.HistoryDAO;
import com.domain.Address;
import com.domain.History;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class HistoryService implements AbstractService<History> {
    @PersistenceContext
    private EntityManager em;


    //   @PersistenceUnit
    //   private EntityManagerFactory factory;

    private final HistoryDAO historyDAO;

    public HistoryService(HistoryDAO historyDAO) {
        this.historyDAO = historyDAO;
    }

    public void save(History history) {
        historyDAO.save(history);
    }

    @Override
    public void removeById(int id) {
        historyDAO.removeById(id);
    }

    @Override
    public void update(History history) {
        historyDAO.update(history);
    }

    @Override
    public History getById(int id) {
        return historyDAO.getById(id);
    }
}
