/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qldv.pojo.Route;
import com.qldv.pojo.Trip;
import com.qldv.repository.RouteRepository;
import com.qldv.service.impl.RouteServiceImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class RouteRepositoryImpl implements RouteRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Route> getRoutes() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Route> query = builder.createQuery(Route.class);
        Root root = query.from(Route.class);
        query = query.select(root);

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Route> getRoutes(Map<String, String> params, int start, int limit) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Route> query = builder.createQuery(Route.class);
        Root root = query.from(Route.class);
        query = query.select(root);

        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = builder.like(root.get("startingpoint").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p2 = builder.like(root.get("destination").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p3 = builder.like(root.get("routename").as(String.class),
                        String.format("%%%s%%", kw));
                query.where(builder.or(p1, p2, p3));
            }
            
        }

        Query q = session.createQuery(query);
        q.setFirstResult(start);
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public List<Route> getListNav(int start, int limit) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query query = session.createQuery("FROM Route");
            query.setFirstResult(start);
            query.setMaxResults(limit);
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addRoute(Route r) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(r);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean editRoute(Route r) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
//            File file = new File(r.getImage());
//        FileInputStream input;
//        try {
//            input = new FileInputStream(file);
//            MultipartFile multipartFile = new MockMultipartFile("file",
//            file.getName(), "text/plain", IOUtils.toByteArray(input));
//            Map m = this.cloudinary.uploader().upload(multipartFile.getBytes(),
//                    ObjectUtils.asMap("resource_type", "auto"));
//            r.setImage((String)m.get("secure_url"));
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(RouteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(RouteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
            session.update(r);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRoute(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Route p = session.get(Route.class, id);
            session.delete(p);

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
            Query q = session.createQuery("SELECT count(*) FROM Route");
            return Integer.parseInt(q.getSingleResult().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int countItem(Object obj) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query q = session.createQuery("SELECT count(*) FROM Object");
            return Integer.parseInt(q.getSingleResult().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Route findById(int routeId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(Route.class, routeId);
    }

    @Override
    public List<Route> getRoutes(String kw, String kw1, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Route> query = builder.createQuery(Route.class);
        Root root = query.from(Route.class);
        query = query.select(root);

        if (kw != null && !kw.isEmpty() && kw1 != null && !kw1.isEmpty()) {
            Predicate p = builder.like(root.get("startingpoint").as(String.class),
                    String.format("%%%s%%", kw));
            Predicate p1 = builder.like(root.get("destination").as(String.class),
                    String.format("%%%s%%", kw1));
            query = query.where(p, p1);
        }
        org.hibernate.query.Query q = session.createQuery(query);
        //Phân trang
        int max = 6;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        return q.getResultList();
    }

    @Override
    public List<Route> getRouteById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Route> query = builder.createQuery(Route.class);
        Root root = query.from(Route.class);
        query.select(root);
//        if (id !=0) {
//            Predicate p = builder.like(root.get("id").as(Integer.class));
//            query = query.where(p);
//        }

        org.hibernate.query.Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Trip> getTripByRoute(int id) {
        List<Trip> trips = null;
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Route rou = session.get(Route.class, id);

        if (rou != null) {
            Hibernate.initialize(rou.getTrips());
            trips = rou.getTrips();
        }

        return trips;
    }

    @Override
    public long countRoute() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Route");
        return Long.parseLong(q.getSingleResult().toString());
    }
}
