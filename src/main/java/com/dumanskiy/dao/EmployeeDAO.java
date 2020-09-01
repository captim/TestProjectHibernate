package com.dumanskiy.dao;

import com.dumanskiy.model.Employee;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    Employee getEmployee(int id);
    Iterable<Employee> getEmployees();
}
