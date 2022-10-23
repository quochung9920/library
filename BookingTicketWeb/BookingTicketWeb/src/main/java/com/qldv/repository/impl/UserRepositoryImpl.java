/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qldv.pojo.User;
import com.qldv.repository.UserRepository;
import com.qldv.service.impl.UserServiceImpl;
import java.io.IOException;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dieuh
 */
@Repository
@Transactional()
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);
            return true;
        } catch (HibernateException ex) {
            System.err.println("Đã có lỗi xảy ra " + ex.getMessage());
        }
        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);

        if (!username.isEmpty()) {
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());

            Predicate p1 = builder.equal(root.get("userrole").as(String.class), username.trim());

            query = query.where(builder.or(p, p1));
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public User getUserByUsername(String name) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query.select(root);
        if (!name.isEmpty()) {
            Predicate p = builder.equal(root.get("name").as(String.class), name.trim());
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        return (User) q.getSingleResult();
    }

    @Override
    public User add(String name, String username, String password, String confirmPassword,
            String email, String phone, String avtUrl) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        User newUser = new User();
        newUser.setName(name);
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPhone(phone);
        newUser.setPassword(this.passwordEncoder.encode(newUser.getPassword()));//Băm mật khẩu
        newUser.setActive(Boolean.TRUE);
        newUser.setUserrole(User.DRIVER);
        Map r;
        try {
            r = this.cloudinary.uploader().upload(newUser.getAvt().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));

            newUser.setAvatar((String) r.get("secure_url"));
        } catch (IOException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.save(newUser);

        return newUser;
    }

    @Override
    public User addU(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);

            return user;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public User getById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public boolean editUser(User u) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.update(u);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public int totalItem(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Query q = session.createQuery("SELECT count(*) FROM User WHERE userrole =: kw");
            q.setParameter("kw", kw);
            return Integer.parseInt(q.getSingleResult().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> getUserName() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root.get("username"));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public String getPassById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query.select(root.get("password"));
        query = query.where(builder.equal(root.get("id"), id));

        Query q = session.createQuery(query);
        return q.getSingleResult().toString();
    }

}
