/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.Driver;
import com.qldv.pojo.User;
import com.qldv.service.DriverService;
import com.qldv.service.RouteService;
import com.qldv.service.UserService;
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
@RequestMapping("admin/drivers")
public class DriverManageController {
    @Autowired
    private DriverService driverService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RouteService routeService;

    @GetMapping("/list")
    public String viewDriverList(ModelMap mm) {
        mm.addAttribute("listDrivers", driverService.getListNav(0, 8));
        mm.addAttribute("totalItem", driverService.totalItem() / 8);
        return "drivers";
    }

    @GetMapping("/list/{page}")
    public String viewDriverListByPage(ModelMap mm, @PathVariable("page") int page) {
        mm.addAttribute("listDrivers", driverService.getListNav((page - 1) * 8, 8));
        mm.addAttribute("totalItem", driverService.totalItem() / 8);
        return "drivers";
    }
    
    @GetMapping("/adddriver")
    public String viewDriverNew() {
        return "adddriver";
    }

    @GetMapping("/editdriver/{driverId}")
    public String viewDriverEdit(ModelMap mm, @PathVariable("driverId") int driverId) {
        mm.addAttribute("driver", driverService.findById(driverId));
        mm.addAttribute("user", userService.getById(driverId));
        return "updatedriver";
    }
    
    @RequestMapping("/deletedriver/{driverId}")
    public String viewRouteRemove(ModelMap mm, @PathVariable("driverId") int driverId) {
        driverService.deleteDriver(driverId);
        viewDriverList(mm);
        return "drivers";
    }

    @GetMapping("/search")
    public String search(@RequestParam Map<String, String> params, ModelMap mm) {
        if (params.get("kw").equals("")) {
            return "redirect:/admin/drivers/list";
        }
        mm.addAttribute("listDrivers", driverService.getDrivers(params, 0, 8));
        mm.addAttribute("totalItem", routeService.totalItem() / 8);
        return "drivers";
    }
}
