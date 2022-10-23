/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.User;
import com.qldv.service.UserService;
import java.util.List;
import java.util.Map;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiUserProfileController {

    @Autowired
    private UserService userDetailService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PutMapping(path = "/user-profile/edit/customer")
    @ResponseStatus(HttpStatus.OK)
    public void editProfileCustomer(@RequestBody Map<String, String> params) {
        try {
            String name = params.get("name");
            String email = params.get("email");
            String phone = params.get("phone");
            String userId = params.get("userId");
            User updateU = this.userDetailService.getById(Integer.parseInt(userId));
            updateU.setName(name);
            updateU.setEmail(email);
            updateU.setPhone(phone);
            this.userDetailService.editUser(updateU);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @PutMapping(path = "/user-profile/edit/avatar")
    @ResponseStatus(HttpStatus.OK)
    public void updateAvatar(@RequestBody Map<String, String> params) {
        try {
            String urlImage = params.get("urlImage");
            int id = Integer.parseInt(params.get("id"));

            User u = this.userDetailService.getById(id);

            u.setAvatar(urlImage);

            this.userDetailService.editUser(u);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @PutMapping(path = "/user-profile/edit/upassword")
    public void updateUPass(@RequestBody Map<String, String> params, HttpSecurity http) {
        try {
            String username = params.get("username");
            String passwordN = params.get("passwordN");
//            String passwordO = params.get("passwordO");
            int id = Integer.parseInt(params.get("id"));

//            String check = this.passwordEncoder.encode(passwordO);
//            List<User> list = this.userDetailService.getUserName();
//            for (User l : list) {
//                if (l.getUsername() != username && passwordO.equals(check)) {
//                    User u = this.userDetailService.getById(id);
//
//                    u.setUsername(username);
//                    u.setPassword(this.passwordEncoder.encode(passwordN));//Băm mật khẩu
//
//                    this.userDetailService.editUser(u);
//                }
//            }
//            if (passwordO.equals(check)) {
                User u = this.userDetailService.getById(id);

                u.setUsername(username);
                u.setPassword(this.passwordEncoder.encode(passwordN));//Băm mật khẩu

                this.userDetailService.editUser(u);
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
