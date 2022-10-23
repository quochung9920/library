/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.User;
import com.qldv.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class UserController {

    @Autowired
    private UserService userDetailService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registerProcess(Model model, @ModelAttribute(value = "user") @Valid User user, BindingResult result) {
        String errMsg = "";

        if (user.getPassword().isEmpty()
                || !user.getPassword().equals(user.getConfirmPassword())) {
            errMsg = "Mật khẩu không khớp !";
            model.addAttribute("errMsg", errMsg);
        } else {
            if (this.userDetailService.addUser(user) == true) {
                return "redirect:/login";
            } else {
                errMsg = "Đã có lỗi xảy ra!";
                model.addAttribute("errMsg", errMsg);
            }
        }

        return "register";

    }
}
