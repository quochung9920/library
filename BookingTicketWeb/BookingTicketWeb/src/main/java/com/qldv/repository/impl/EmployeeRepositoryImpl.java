/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository.impl;

import com.qldv.pojo.Employee;
import com.qldv.pojo.User;
import com.qldv.repository.EmployeeRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Employee> getEmployees(Map<String, String> params, int start, int limit) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root root = query.from(Employee.class);
        Root rootU = query.from(User.class);
        query = query.select(root);
        Predicate p = builder.equal(root.get("userIdEmployee"), rootU.get("id"));

        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = builder.like(root.get("address").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p2 = builder.like(root.get("gender").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p3 = builder.like(root.get("identitycard").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p4 = builder.like(rootU.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p5 = builder.like(rootU.get("email").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p6 = builder.like(rootU.get("phone").as(String.class),
                        String.format("%%%s%%", kw));
                query = query.where(builder.or(p1, p2, p3, p4, p5, p6), builder.and(p));
            }
        }

        Query q = session.createQuery(query);
        q.setFirstResult(start);
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public List<Employee> getListNav(int start, int limit) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query query = session.createQuery("FROM Employee");
            query.setFirstResult(start);
            query.setMaxResults(limit);
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addEmployee(Employee e) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(e);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean editEmployee(Employee e) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.update(e);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Employee e = session.get(Employee.class, id);
            session.delete(e);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public int totalItem() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query q = session.createQuery("SELECT count(*) FROM Employee");
            return Integer.parseInt(q.getSingleResult().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Employee findById(int employeeId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Employee.class, employeeId);
    }

    @Override
    public Employee addE(Employee employee) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(employee);

            return employee;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
