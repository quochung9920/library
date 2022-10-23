/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.service;

import com.qldv.pojo.User;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author dieuh
 */
public interface UserService extends UserDetailsService {
//    User getUserById(int id);

    boolean addUser(User user);

    List<User> getUsers(String username);

    List<User> getUserName();
    
    User getUserByUsername(String username);
    
    String getPassById(int userId);

    User add(String name, String username, String password, String confirmPassword,
            String email, String phone, String avtUrl);

    User addU(User user);

    User addUE(User user);

    User getById(int userId);

    boolean editUser(User u);
    
    int totalItem(String kw);
}
