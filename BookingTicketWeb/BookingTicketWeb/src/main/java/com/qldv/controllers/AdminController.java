/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.Route;
import com.qldv.service.DriverDetailService;
import com.qldv.service.PassengerService;
import com.qldv.service.RouteService;
import com.qldv.service.TicketDetailService;
import com.qldv.service.TripService;
import com.qldv.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ASUS
 */
@Controller

public class AdminController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private TicketDetailService ticketDetailService;

    @Autowired
    private RouteService routeService;
    
    @Autowired
    private TripService tripService;
    
    @Autowired
    private PassengerService passengerService;
   
    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("totalRoute",routeService.totalItem());
        model.addAttribute("totalTrip",tripService.totalItem());
        model.addAttribute("totalCustomer",userService.totalItem("Customer"));
        model.addAttribute("totalDriver",userService.totalItem("Driver"));
        model.addAttribute("totalEmployee",userService.totalItem("Employee"));
        model.addAttribute("totalAdmin",userService.totalItem("Admin"));
        model.addAttribute("totalTicket",ticketDetailService.totalItem());
        model.addAttribute("totalPassenger",passengerService.totalItem());
        model.addAttribute("totalAmount",ticketDetailService.sumItem());
        return "admin";
    }

}
