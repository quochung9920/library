/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qldv.pojo.User;
import com.qldv.repository.UserRepository;
import com.qldv.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dieuh
 */
@Service("userDetailService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    @Transactional
    public boolean addUser(User user) {

        try {
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));//Băm mật khẩu
            user.setActive(Boolean.TRUE);
            user.setUserrole(User.CUSTOMER);
            Map r = this.cloudinary.uploader().upload(user.getAvt().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            user.setAvatar((String) r.get("secure_url"));
            return this.userRepository.addUser(user);
        } catch (IOException ex) {

            ex.printStackTrace();
        }
        return false;
    }


    @Override
    public List<User> getUsers(String username) {
        return this.userRepository.getUsers(username);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Username không tồn tại!");
        }

        User user = users.get(0);

        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserrole()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        return userRepository.getUsers(username).get(0);
    }

    @Override
    public User add(String name, String username, String password, String confirmPassword,
            String email, String phone, String avtUrl) {
        return this.userRepository.add(name, username, password, confirmPassword, email, phone, avtUrl);
    }

    @Override
    public User addU(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));//Băm mật khẩu
        user.setActive(Boolean.TRUE);
        user.setUserrole(User.DRIVER);
        return this.userRepository.addU(user);
    }

    @Override
    public User addUE(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));//Băm mật khẩu
        user.setActive(Boolean.TRUE);
        return this.userRepository.addU(user);
    }

    @Override
    public User getById(int id) {
        return this.userRepository.getById(id);
    }

    @Override
    public boolean editUser(User user) {
        return this.userRepository.editUser(user);
    }

    @Override
    public int totalItem(String kw) {
        return this.userRepository.totalItem(kw);
    }

    @Override
    public List<User> getUserName() {
        return this.userRepository.getUserName();
    }

    @Override
    public String getPassById(int id) {
        return this.userRepository.getPassById(id);
    }

}
