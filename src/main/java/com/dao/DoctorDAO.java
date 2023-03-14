package com.dao;

import com.domain.Doctor;

public interface DoctorDAO {
    void save(Doctor doctor);
    void update(Doctor doctor);
    void removeById(int id);
    Doctor getById(int id);
}
