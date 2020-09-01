package com.dumanskiy.dao;

import com.dumanskiy.hibernate.HibernateUtil;
import com.dumanskiy.model.Department;
import com.dumanskiy.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class HibernateDAO implements EmployeeDAO, DepartmentDAO {
    private static HibernateDAO instance;
    private SessionFactory sessionFactory;
    private HibernateDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public static HibernateDAO getInstance() {
        if (instance == null) {
            instance = new HibernateDAO();
        }
        return instance;
    }

    @Override
    public void addDepartment(Department department) {
        add(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        delete(department);
    }

    @Override
    public Department getDepartment(int id) {
        Session session = sessionFactory.openSession();
        Department department = null;
        try {
            department = session.get(Department.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (department == null) {
            throw new IllegalArgumentException("Hadn't found " + id + "'th department");
        }
        return department;
    }

    @Override
    public Iterable<Department> getDepartments() {
        Session session = sessionFactory.openSession();
        Iterable<Department> departments = null;
        try {
            departments = session.createCriteria(Department.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return departments;
    }

    @Override
    public void addEmployee(Employee employee) {
        add(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        delete(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.openSession();
        Employee employee = null;
        try {
            employee = session.get(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (employee == null) {
            throw new IllegalArgumentException("Hadn't found " + id + "'th employee");
        }
        return employee;
    }

    @Override
    public Iterable<Employee> getEmployees() {
        Session session = sessionFactory.openSession();
        Iterable<Employee> employees = null;
        try {
            employees = session.createCriteria(Employee.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employees;
    }

    private void add(Object object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            session.close();
        }
    }
    private void delete(Object object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            session.close();
        }
    }
}
