/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository.impl;

import com.qldv.pojo.Driver;
import com.qldv.pojo.User;
import com.qldv.repository.DriverRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DriverRepositoryImpl implements DriverRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Driver> getDrivers(Map<String, String> params, int start, int limit) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Driver> query = builder.createQuery(Driver.class);
        Root root = query.from(Driver.class);
        Root rootU = query.from(User.class);
        query = query.select(root);
        Predicate p = builder.equal(root.get("userIdDriver"), rootU.get("id"));

        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = builder.like(root.get("address").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p2 = builder.like(root.get("license").as(String.class),
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
    public List<Driver> getListNav(int start, int limit) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query query = session.createQuery("FROM Driver");
            query.setFirstResult(start);
            query.setMaxResults(limit);
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addDriver(Driver d) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(d);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean editDriver(Driver d) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(d);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDriver(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Driver d = session.get(Driver.class, id);
            session.delete(d);

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
            Query q = session.createQuery("SELECT count(*) FROM Driver");
            return Integer.parseInt(q.getSingleResult().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Driver findById(int driverId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Driver.class, driverId);
    }

    @Override
    public Driver add(String userIdDriver, String identityCard, String address, String dateOfBirth, String license) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Date date;
        Driver drv = new Driver();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
            drv.setDateofbirth(date);
            drv.setUserIdDriver(Integer.parseInt(userIdDriver));
            drv.setIdentitycard(identityCard);
            drv.setAddress(address);
            drv.setLicense(license);
            session.save(drv);
        } catch (ParseException ex) {
            Logger.getLogger(DriverRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return drv;
    }

    @Override
    public Driver addD(Driver driver) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(driver);

            return driver;
        } catch(HibernateException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

}
