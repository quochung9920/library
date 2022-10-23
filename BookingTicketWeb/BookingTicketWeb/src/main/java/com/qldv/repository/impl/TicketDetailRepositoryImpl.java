/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository.impl;

import com.qldv.pojo.Passengercar;
import com.qldv.pojo.Seat;
import com.qldv.pojo.Ticketdetail;
import com.qldv.pojo.Trip;
import com.qldv.pojo.User;
import com.qldv.repository.PassengerRepository;
import com.qldv.repository.RouteRepository;
import com.qldv.repository.TicketDetailRepository;
import com.qldv.repository.TripRepository;
import com.qldv.repository.UserRepository;
import com.qldv.utils.Utils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class TicketDetailRepositoryImpl implements TicketDetailRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean deleteTicketDetail(int tripId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Ticketdetail t = session.get(Ticketdetail.class, tripId);
            session.delete(t);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Object[]> findTicketsByTripId(int tripId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootT = query.from(Trip.class);
        Root rootR = query.from(Ticketdetail.class);
        Root rootS = query.from(Seat.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(rootR.get("tripId"), rootT.get("id")));
        predicates.add(builder.equal(rootR.get("seatId"), rootS.get("id")));
        predicates.add(builder.equal(rootR.get("tripId"), tripId));
        query = query.multiselect(rootS.get("id"));
        query.where(predicates.toArray(new Predicate[]{}));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Seat> getSeat(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Seat> query = builder.createQuery(Seat.class);
        Root root = query.from(Seat.class);
        query = query.select(root);

        if (kw != null && !kw.isEmpty()) {
            Predicate p1 = builder.like(root.get("seatrow").as(String.class),
                    String.format("%%%s%%", kw));
            query = query.where(p1);
        }

        javax.persistence.Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public long countSeat(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query q = session.createQuery("SELECT count(*) FROM Seat WHERE seatrow =:kw");
            q.setParameter("seatrow", kw);
            return Integer.parseInt(q.getSingleResult().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Object getUsers(String uname) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = builder.createQuery(Object.class);
        Root root = query.from(User.class);
        query = query.multiselect(root.get("name"), root.get("email"), root.get("phone"));
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(root.get("username").as(String.class), uname.trim()));

        query.where(predicates.toArray(new Predicate[]{}));

        Query q = session.createQuery(query);
        return (Object) q.getSingleResult();
    }

    @Override
    public boolean addReceipt(Map<Integer, Seat> seat, int uId, String method) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();

            for (Seat s : seat.values()) {
                Ticketdetail ticket = new Ticketdetail();
                ticket.setCreateddate(new Date());
                ticket.setSeatId(s);
                ticket.setTotalprice(s.getPrice());
                ticket.setPaymentmethod(method);
                ticket.setTripId(this.tripRepository.tripById(s.getTripId()));
                ticket.setUserId(this.userRepository.getById(uId));
                ticket.setPassengercarId(this.passengerRepository.getById(s.getPasCarId()));

                session.save(ticket);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public int totalItem() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query q = session.createQuery("SELECT count(*) FROM Ticketdetail");
            return Integer.parseInt(q.getSingleResult().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Long sumItem() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query q = session.createQuery("SELECT sum(totalprice) FROM Ticketdetail");
            return Long.parseLong(q.getSingleResult().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0l;
    }

    @Override
    public int countTicketsByTripId(int tripId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rootT = query.from(Trip.class);
        Root rootR = query.from(Ticketdetail.class);
        Root rootS = query.from(Seat.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootR.get("tripId"), rootT.get("id")));
        predicates.add(builder.equal(rootR.get("seatId"), rootS.get("id")));
        predicates.add(builder.equal(rootR.get("tripId"), tripId));
        query.multiselect(builder.count(rootS.get("id")));
        query.where(predicates.toArray(new Predicate[]{}));
        Query q = session.createQuery(query);

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public List<Ticketdetail> getTickets(Map<String, String> params, int start, int limit) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Ticketdetail> query = builder.createQuery(Ticketdetail.class);
        Root root = query.from(Ticketdetail.class);
        Root rootU = query.from(User.class);
        Root rootP = query.from(Passengercar.class);
        Root rootT = query.from(Trip.class);
        query = query.select(root);
        Predicate p = builder.equal(root.get("userId"), rootU.get("id"));
        Predicate pp = builder.equal(root.get("passengercarId"), rootP.get("id"));
        Predicate ppp = builder.equal(root.get("tripId"), rootT.get("id"));
        
        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = builder.like(rootT.get("coachname").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p2 = builder.like(rootU.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p3 = builder.like(rootP.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p4 = builder.like(rootU.get("phone").as(String.class),
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
    public List<Ticketdetail> getListNav(int start, int limit) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            javax.persistence.Query query = session.createQuery("FROM Ticketdetail");
            query.setFirstResult(start);
            query.setMaxResults(limit);
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean editTicket(Ticketdetail t) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.update(t);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
