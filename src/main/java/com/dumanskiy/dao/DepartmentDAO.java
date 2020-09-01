package com.dumanskiy.dao;

import com.dumanskiy.model.Department;

public interface DepartmentDAO {
    void addDepartment(Department department);
    void deleteDepartment(Department department);
    Department getDepartment(int id);
    Iterable<Department> getDepartments();
}
