/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository.impl;

import com.qldv.pojo.Comment;
import com.qldv.pojo.User;
import com.qldv.repository.CommentRepository;
import com.qldv.repository.TripRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Autowired
    private TripRepository tripRepository;
    @Override
    public List<Comment> getCommentsByTripId(int tripId, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Comment> query = builder.createQuery(Comment.class);
        Root root = query.from(Comment.class);
        
        query = query.where(builder.equal(root.get("tripId"), tripId));
        query = query.orderBy(builder.desc(root.get("id")));

        Query q = session.createQuery(query);

        int max = 10;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        return q.getResultList();
    }

    @Override
    public long countTrip(int tripId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT Count(*) FROM Comment WHERE tripId.id =: id");
        q.setParameter("id", tripId);
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public Comment addComment(String content, int tripId, User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Comment c = new Comment();
        c.setContent(content);
        c.setTripId(this.tripRepository.tripById(tripId));
        c.setCustomerId(user);
        c.setCreateddate(new Date());
        session.save(c);
        return c;
    }

    @Override
    public boolean deleteComment(int tripId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Comment c = session.get(Comment.class, tripId);
            session.delete(c);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    

}
