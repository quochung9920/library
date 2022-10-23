/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository;

import com.qldv.pojo.Route;
import com.qldv.pojo.Trip;
import java.util.Date;
import java.sql.Time;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface TripRepository {

    List<Trip> getDeparturedayTrips(Date kw, int id);

    List<Trip> findById(int routeId);

    List<Trip> getTrips(String kw);

    List<Trip> getTrips();

    List<Trip> getTrips(Map<String, String> params, int start, int limit);

    List<Trip> getListNav(int start, int limit);

    Route getRouteByTrip(int id);

    Trip addTrip(Trip t);

    boolean editTrip(Trip t);

    boolean deleteTrip(int id);

    int totalItem();

    Trip tripById(int tripId);
    
    List<Trip> tripComment();
}
