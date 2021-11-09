package com.employeemanager.services;

import com.employeemanager.entity.Employee;

public interface IEmployeeService {
    void add();

    void update(int id);

    void delete();

    Employee findById(int id);

    void findAll();

    void findByIntern();

    void findByFresher();

    void findByExperience();
}
