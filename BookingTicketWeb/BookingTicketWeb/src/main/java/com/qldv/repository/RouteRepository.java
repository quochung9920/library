/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository;

import com.qldv.pojo.Route;
import com.qldv.pojo.Trip;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface RouteRepository {

    List<Route> getRoutes(Map<String, String> params, int start, int limit);

    List<Route> getRoutes();

    List<Route> getListNav(int start, int limit);

    boolean addRoute(Route r);

    boolean editRoute(Route r);

    boolean deleteRoute(int id);

    int totalItem();

    int countItem(Object obj);

    Route findById(int routeId);

    List<Route> getRoutes(String kw, String kw1, int page);

    List<Route> getRouteById(int id);

    List<Trip> getTripByRoute(int id);

    long countRoute();
}
