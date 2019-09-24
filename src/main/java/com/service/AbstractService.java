package com.service;

public interface AbstractService<T> {
    void save(T t);
    void update(T t);
    void removeById(int id);
}
