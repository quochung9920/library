/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.Employee;
import com.qldv.pojo.User;
import com.qldv.service.EmployeeService;
import com.qldv.service.UserService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiEmployeeManageController {

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private UserService userService;

    @PostMapping(path = "/api/admin/add-user-epl", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<User> addUser(@RequestBody Map<String, String> params) {
        try {
            String name = params.get("name");
            String username = params.get("username");
            String password = params.get("password");
            String confirmPassword = params.get("confirmPassword");
            String email = params.get("email");
            String phone = params.get("phone");
            String avtUrl = params.get("avt");
            String userrole = params.get("userrole");

            User newUser = new User();
            newUser.setName(name);
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setEmail(email);
            newUser.setPhone(phone);
            newUser.setAvatar(avtUrl);
            newUser.setUserrole(userrole);

            if (password.equals(confirmPassword)) {
                User u = this.userService.addUE(newUser);
                return new ResponseEntity<>(u, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/api/admin/add-employee", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Employee> addDriver(@RequestBody Map<String, String> params) {
        try {

            String userIdEmployee = params.get("userIdEmployee");
            String identityCard = params.get("identityCard");
            String address = params.get("address");
            String dateOfBirth = params.get("dateOfBirth");
            String gender = params.get("gender");

            Employee e = new Employee();

            e.setUserIdEmployee(Integer.parseInt(userIdEmployee));
            e.setIdentitycard(identityCard);
            e.setAddress(address);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
            e.setDateofbirth(date);
            e.setGender(gender);

            Employee newEml = this.employeeService.addE(e);

            return new ResponseEntity<>(newEml, HttpStatus.CREATED);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PutMapping(path = "/api/admin/update-user-employee")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody Map<String, String> params) {
        try {
            String name = params.get("name");
            String email = params.get("email");
            String phone = params.get("phone");
            int userIdEmployee = Integer.parseInt(params.get("userIdEmployee"));

            User updateUser = this.userService.getById(userIdEmployee);
            updateUser.setName(name);
            updateUser.setEmail(email);
            updateUser.setPhone(phone);

            this.userService.editUser(updateUser);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @PutMapping(path = "/api/admin/update-employee")
    @ResponseStatus(HttpStatus.OK)
    public void updateDriver(@RequestBody Map<String, String> params) {
        try {
            String identityCard = params.get("identityCard");
            String address = params.get("address");
            String dateOfBirth = params.get("dateOfBirth");
            String gender = params.get("gender");
            int userIdEmployee = Integer.parseInt(params.get("userIdEmployee"));

            Employee empl = this.employeeService.findById(userIdEmployee);

            empl.setIdentitycard(identityCard);
            empl.setAddress(address);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
            empl.setDateofbirth(date);
            empl.setGender(gender);

            this.employeeService.editEmployee(empl);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
