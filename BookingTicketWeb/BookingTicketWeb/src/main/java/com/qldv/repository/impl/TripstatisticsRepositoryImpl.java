/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository.impl;


import com.qldv.pojo.Route;
import com.qldv.pojo.Ticketdetail;
import com.qldv.pojo.Trip;
import com.qldv.repository.TripstatisticsRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dieuh
 */
@Repository
@Transactional
public class TripstatisticsRepositoryImpl implements TripstatisticsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> tripStatsByRouteId() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootT = query.from(Trip.class);
        Root rootR = query.from(Route.class);
//        Join<Route,Trip> rootT = rootR.join("rootT", JoinType.LEFT);
//        rootT.on(builder.and(builder.equal(rootT.get("route"), rootR.get("id"))));
        query = query.where(builder.equal(rootT.get("routeId"), rootR.get("id")));
        
        query.multiselect(rootR.get("id"), rootR.get("routename"), builder.count(rootT.get("id")));
        
        query.groupBy(rootR.get("id"), rootR.get("routename"));
        query.orderBy(builder.asc(rootT.get("id")));
        Query q = session.createQuery(query);
        
//        Query q = session.createQuery("SELECT r.id, r.routename FROM Trip t, Route r WHERE t.route =: r.id GROUPBY r.id, r.routename");

        return q.getResultList();
    }

    @Override
    public List<Object[]> tripStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        Root rootT = query.from(Trip.class);
        Root rootTick = query.from(Ticketdetail.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootTick.get("tripId"), rootT.get("id")));
        

        query.multiselect(rootT.get("id"), rootT.get("coachname"),builder.sum(rootTick.get("totalprice")));
        
        if(kw != null && !kw.isEmpty()) {
            predicates.add(builder.like(rootT.get("coachname"), String.format("%%%s%%", kw)));
        }
        if(fromDate != null) {
            predicates.add(builder.greaterThanOrEqualTo(rootTick.get("createddate"), fromDate));
        }
        if(toDate != null) {
            predicates.add(builder.lessThanOrEqualTo(rootTick.get("createddate"), toDate));
        }
        query.where(predicates.toArray(new Predicate[] {}));
        query.groupBy(rootT.get("id"), rootT.get("coachname"));
        query.orderBy(builder.asc(rootT.get("id")));
        Query q = session.createQuery(query);
        return q.getResultList();
    }



    @Override
    public List<Object[]> tripMonthStats(Date fromDate, Date toDate) {
    Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        Root rootT = query.from(Trip.class);
        Root rootTick = query.from(Ticketdetail.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootTick.get("tripId"), rootT.get("id")));
        

        query.multiselect(builder.function("MONTH", Integer.class, rootTick.get("createddate")),builder.function("YEAR", Integer.class, rootTick.get("createddate")),builder.sum(rootTick.get("totalprice")));
        
        if(fromDate != null) {
            predicates.add(builder.greaterThanOrEqualTo(rootTick.get("createddate"), fromDate));
        }
        if(toDate != null) {
            predicates.add(builder.lessThanOrEqualTo(rootTick.get("createddate"), toDate));
        }
        query.where(predicates.toArray(new Predicate[] {}));
        query.groupBy(builder.function("MONTH", Integer.class, rootTick.get("createddate")),builder.function("YEAR", Integer.class, rootTick.get("createddate")));
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Object[]> tripYearStats( Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        Root rootT = query.from(Trip.class);
        Root rootTick = query.from(Ticketdetail.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootTick.get("tripId"), rootT.get("id")));
        

        query.multiselect(builder.function("YEAR", Integer.class, rootTick.get("createddate")),builder.sum(rootTick.get("totalprice")));
        
        if(fromDate != null) {
            predicates.add(builder.greaterThanOrEqualTo(rootTick.get("createddate"), fromDate));
        }
        if(toDate != null) {
            predicates.add(builder.lessThanOrEqualTo(rootTick.get("createddate"), toDate));
        }
        query.where(predicates.toArray(new Predicate[] {}));
        query.groupBy(builder.function("YEAR", Integer.class, rootTick.get("createddate")));
        //query.orderBy((List<Order>) builder.function("YEAR", Integer.class, rootTick.get("createddate")));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Object[]> tripQuarterStats(Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        Root rootT = query.from(Trip.class);
        Root rootTick = query.from(Ticketdetail.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootTick.get("tripId"), rootT.get("id")));
        

        query.multiselect(builder.function("QUARTER", Integer.class, rootTick.get("createddate")),builder.function("YEAR", Integer.class, rootTick.get("createddate")),builder.sum(rootTick.get("totalprice")));
        
        if(fromDate != null) {
            predicates.add(builder.greaterThanOrEqualTo(rootTick.get("createddate"), fromDate));
        }
        if(toDate != null) {
            predicates.add(builder.lessThanOrEqualTo(rootTick.get("createddate"), toDate));
        }
        query.where(predicates.toArray(new Predicate[] {}));
        query.groupBy(builder.function("QUARTER", Integer.class, rootTick.get("createddate")),builder.function("YEAR", Integer.class, rootTick.get("createddate")));
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }
}
