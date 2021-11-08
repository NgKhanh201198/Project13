package com.employee_manager.services;

import com.employee_manager.entity.Employee;

public interface IEmployeeService {
    void add();

    void update(int id);

    void delete(int id);

    Employee findById(int id);

    void findAll();

    void findByIntern();

    void findByFresher();

    void findByExperience();
}
