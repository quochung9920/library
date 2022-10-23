/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.Route;
import com.qldv.service.RouteService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiRouteManageController {

    @Autowired
    private RouteService routeService;

    @PutMapping(path = "/api/admin/update-image-route")
    @ResponseStatus(HttpStatus.OK)
    public void updateImageRoute(@RequestBody Map<String, String> params) {
        try {
            String urlImage = params.get("urlImage");
            int id = Integer.parseInt(params.get("id"));

            Route r = this.routeService.findById(id);

            r.setImage(urlImage);

            this.routeService.editRoute(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
