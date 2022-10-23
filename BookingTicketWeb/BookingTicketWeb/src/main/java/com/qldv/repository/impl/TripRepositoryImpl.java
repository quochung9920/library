/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository.impl;

import com.qldv.pojo.Passengercar;
import com.qldv.pojo.Route;
import com.qldv.pojo.Trip;
import com.qldv.pojo.User;
import com.qldv.repository.TripRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class TripRepositoryImpl implements TripRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    

    @Override
    public List<Trip> getDeparturedayTrips(Date kw, int id) {

        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery(Trip.class);
        Root rootT = query.from(Trip.class);
        Root rootR = query.from(Route.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(rootT.get("routeId"), rootR.get("id")));
        predicates.add(builder.equal(rootT.get("routeId"), id));
        query = query.select(rootT);

        if (kw != null) {
            predicates.add(builder.equal(rootT.get("departureday"), kw));
        }
        query.where(predicates.toArray(new Predicate[]{}));
        query.orderBy(builder.asc(rootT.get("departureday")));
        org.hibernate.query.Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Trip> findById(int routeId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query query = session.createQuery("FROM Trip WHERE routeId = :routeId");
            query.setParameter("routeId", routeId);
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Trip> getTrips(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery(Trip.class);
        Root root = query.from(Trip.class);
        query = query.select(root);
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public List<Trip> getTrips(Map<String, String> params, int start, int limit) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery(Trip.class);
        Root root = query.from(Trip.class);
        Root rootU = query.from(User.class);
        Root rootR = query.from(Route.class);
        Root rootP = query.from(Passengercar.class);
        query = query.select(root);
        Predicate p = builder.equal(root.get("userIdEmployee"), rootU.get("id"));
        Predicate pp = builder.equal(root.get("routeId"), rootR.get("id"));
        Predicate ppp = builder.equal(root.get("passengercarId"), rootP.get("id"));
        
        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = builder.like(root.get("coachname").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p2 = builder.like(rootU.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p3 = builder.like(rootR.get("routename").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p4 = builder.like(rootP.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                query = query.where(builder.or(p1, p2, p3, p4), builder.and(p, pp, ppp));
            }
        }

        Query q = session.createQuery(query);
        q.setFirstResult(start);
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public List<Trip> getListNav(int start, int limit) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query query = session.createQuery("FROM Trip");
            query.setFirstResult(start);
            query.setMaxResults(limit);
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Trip addTrip(Trip t) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(t);
            return t;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean editTrip(Trip t) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.update(t);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTrip(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Trip t = session.get(Trip.class, id);
            session.delete(t);

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
            Query q = session.createQuery("SELECT count(*) FROM Trip");
            return Integer.parseInt(q.getSingleResult().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Trip tripById(int tripId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Trip.class, tripId);
    }

    @Override
    public Route getRouteByTrip(int id) {
        Route r = new Route();
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Trip t = session.get(Trip.class, id);

        if (t != null) {
            Hibernate.initialize(t.getRouteId());
            r = t.getRouteId();
        }

        return r;
    }

    @Override
    public List<Trip> getTrips() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery(Trip.class);
        Root root = query.from(Trip.class);
        query = query.select(root);
        query = query.where(builder.equal(root.get("active"), 1));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Trip> tripComment() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery(Trip.class);
        Root rootT = query.from(Trip.class);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        long s = System.currentTimeMillis();
        
        Date day = new Date(s);
        query = query.select(rootT);
        Predicate p1 = builder.lessThanOrEqualTo(rootT.get("departureday"),day);
        query = query.where(p1);

        Query q = session.createQuery(query);
        return q.getResultList();
    }

}
