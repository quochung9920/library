/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.Route;
import com.qldv.service.RouteService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("admin/routes")
public class RouteManageController {
    
    @Autowired
    private RouteService routeService;
    
    @GetMapping("/list")
    public String viewRouteList(ModelMap mm) {
        mm.addAttribute("listRoutes", routeService.getListNav(0, 8));
        mm.addAttribute("totalItem", Math.ceil(routeService.totalItem()) / 8);
        return "routes";
    }
    
    @GetMapping("/list/{page}")
    public String viewRouteListByPage(ModelMap mm, @PathVariable("page") int page) {
        mm.addAttribute("listRoutes", routeService.getListNav((page - 1) * 8, 8));
        mm.addAttribute("totalItem", Math.ceil(routeService.totalItem()) / 8);
        return "routes";
    }
    
    @GetMapping("/addroute")
    public String viewRouteNew(ModelMap mm) {
        mm.addAttribute("route", new Route());
        return "addroute";
    }
    
    @GetMapping("/editroute/{routeId}")
    public String viewRouteEdit(ModelMap mm, @PathVariable("routeId") int routeId) {
        mm.addAttribute("route", routeService.findById(routeId));
        return "updateroute";
    }
    
    @GetMapping("/editroute/image/{routeId}")
    public String viewRouteEditImage(ModelMap mm, @PathVariable("routeId") int routeId) {
        mm.addAttribute("route", routeService.findById(routeId));
        return "edit_image_route";
    }
    
    @PostMapping("/editroute")
    public String doUpdateRoute(ModelMap mm, @ModelAttribute(value = "route") Route route,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "updateroute";
        }
        if (this.routeService.editRoute(route) == true) {
            viewRouteList(mm);
            return "redirect:/admin/routes/list";
        }
        return "updateroute";
    }
    
    @PostMapping("/saveroute")
    public String viewRouteSave(ModelMap mm, @ModelAttribute(value = "route") @Valid Route route,
            BindingResult rs, HttpServletRequest request) {
        if (rs.hasErrors()) {
            return "addroute";
        }
        if (this.routeService.addRoute(route) == true) {
            viewRouteList(mm);
            return "redirect:/admin/routes/list";
        }
        return "addroute";
    }
    
    @RequestMapping("/deleteroute/{routeId}")
    public String viewRouteRemove(ModelMap mm, @PathVariable("routeId") int routeId) {
        routeService.deleteRoute(routeId);
        viewRouteList(mm);
        return "routes";
    }
    
    @GetMapping("/search")
    public String search(@RequestParam Map<String, String> params, ModelMap mm) {
        if (params.get("kw").equals("")) {
            return "redirect:/admin/routes/list";
        }
        mm.addAttribute("listRoutes", routeService.getRoutes(params, 0, 8));
        mm.addAttribute("totalItem", routeService.countItem(routeService.getRoutes(params, 0, 8)) / 8);
        return "routes";
    }
    
}
