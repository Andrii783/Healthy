package com.dao;

import com.domain.History;

public interface HistoryDAO {
    void save(History history);
    void update(History history);
    void removeById(int id);
    History getById(int id);
}
