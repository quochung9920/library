/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository;

import com.qldv.pojo.User;
import java.util.List;

/**
 *
 * @author dieuh
 */
public interface UserRepository {

    boolean addUser(User user);

    List<User> getUsers(String username);

    List<User> getUserName();

    String getPassById(int userId);

    User getUserByUsername(String username);
//   User getUserById(int id);

    User add(String name, String username, String password, String confirmPassword,
            String email, String phone, String avtUrl);

    User addU(User user);

    User getById(int userId);

    boolean editUser(User u);

    int totalItem(String kw);
}
