/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository.impl;

import com.qldv.pojo.Driver;
import com.qldv.pojo.Driverdetail;
import com.qldv.pojo.Trip;
import com.qldv.pojo.User;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.qldv.repository.DriverDetailRepository;
import javax.persistence.criteria.Predicate;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class DriverDetaiRepositoryImpl implements DriverDetailRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Driverdetail> getDrivers(Map<String, String> params, int start, int limit) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Driverdetail> query = builder.createQuery(Driverdetail.class);
        Root root = query.from(Driverdetail.class);
        Root rootT = query.from(Trip.class);
        Root rootU = query.from(User.class);
        query = query.select(root);
        Predicate p = builder.equal(root.get("userIdDriver"), rootU.get("id"));
        Predicate pp = builder.equal(root.get("tripId"), rootT.get("id"));
        
        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = builder.like(rootT.get("coachname").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p2 = builder.like(rootU.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p3 = builder.like(root.get("driverrole").as(String.class),
                        String.format("%%%s%%", kw));
                query = query.where(builder.or(p1, p2, p3), builder.and(p, pp));
            }
        }

        Query q = session.createQuery(query);
        q.setFirstResult(start);
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public List<Driverdetail> getListNav(int start, int limit) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query query = session.createQuery("FROM Driverdetail");
            query.setFirstResult(start);
            query.setMaxResults(limit);
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean editDriver(Driverdetail d) {
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
    public int totalItem() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query q = session.createQuery("SELECT count(*) FROM Driverdetail");
            return Integer.parseInt(q.getSingleResult().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Driverdetail findById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Driverdetail.class, id);
    }

    @Override
    public boolean addDriver(Driverdetail d) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(d);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
