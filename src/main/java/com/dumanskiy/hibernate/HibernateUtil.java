package com.dumanskiy.hibernate;

import com.dumanskiy.model.Department;
import com.dumanskiy.model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    static  {
        Configuration cfg = new Configuration().configure();
        cfg.addAnnotatedClass(Employee.class);
        cfg.addAnnotatedClass(Department.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
        sessionFactory = cfg.buildSessionFactory(builder.build());
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}