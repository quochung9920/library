/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qldv.pojo.Route;
import com.qldv.pojo.Trip;
import com.qldv.repository.RouteRepository;
import com.qldv.service.RouteService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Route> getRoutes() {
        return this.routeRepository.getRoutes();
    }

    @Override
    public List<Route> getRoutes(Map<String, String> params, int start, int limit) {
        return this.routeRepository.getRoutes(params, start, limit);
    }

    @Override
    public boolean addRoute(Route route) {
        try {
            Map r = this.cloudinary.uploader().upload(route.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            route.setImage((String) r.get("secure_url"));
            return this.routeRepository.addRoute(route);
        } catch (IOException ex) {

            ex.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean editRoute(Route r) {
        return this.routeRepository.editRoute(r);
    }

    @Override
    public boolean deleteRoute(int id) {
        return this.routeRepository.deleteRoute(id);
    }

    @Override
    public int totalItem() {
        return this.routeRepository.totalItem();
    }

    @Override
    public int countItem(Object obj) {
        return this.routeRepository.countItem(obj);
    }

    @Override
    public Route findById(int i) {
        return this.routeRepository.findById(i);
    }

    @Override
    public List<Route> getListNav(int start, int limit) {
        return this.routeRepository.getListNav(start, limit);
    }

    @Override
    public List<Route> getRoutes(String kw, String kw1, int page) {
        return this.routeRepository.getRoutes(kw, kw1, page);
    }

    @Override
    public List<Route> getRouteById(int id) {
        return this.routeRepository.getRouteById(id);
    }

    @Override
    public List<Trip> getTripByRoute(int id) {
        return this.routeRepository.getTripByRoute(id);
    }

    @Override
    public long countRoute() {
        return this.routeRepository.countRoute();
    }

}
