/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.Route;
import com.qldv.pojo.Ticketdetail;
import com.qldv.service.RouteService;
import com.qldv.service.TicketDetailService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/tickets")
public class TicketManageController {
    @Autowired
    private TicketDetailService ticketDetailService;
    
    @Autowired
    private RouteService routeService;
    
    @GetMapping("/list")
    public String viewTicketList(ModelMap mm) {
        mm.addAttribute("listTickets", ticketDetailService.getListNav(0, 20));
        mm.addAttribute("totalItem", Math.ceil(ticketDetailService.totalItem()) / 20);
        return "tickets";
    }
    
    @GetMapping("/list/{page}")
    public String viewTicketListByPage(ModelMap mm, @PathVariable("page") int page) {
        mm.addAttribute("listTickets", ticketDetailService.getListNav((page - 1) * 20, 20));
        mm.addAttribute("totalItem", Math.ceil(ticketDetailService.totalItem()) / 20);
        return "tickets";
    }
    
    @GetMapping("/search")
    public String search(@RequestParam Map<String, String> params, ModelMap mm) {
        if (params.get("kw").equals("")) {
            return "redirect:/tickets/list";
        }
        mm.addAttribute("listTickets", ticketDetailService.getTickets(params, 0, 20));
        mm.addAttribute("totalItem", routeService.countItem(ticketDetailService.getTickets(params, 0, 20)) / 20);
        return "tickets";
    }
}
