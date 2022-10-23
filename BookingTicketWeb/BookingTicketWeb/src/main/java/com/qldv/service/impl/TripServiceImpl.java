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
import com.qldv.repository.TicketDetailRepository;
import com.qldv.repository.TripRepository;
import com.qldv.repository.impl.CommentRepositoryImpl;
import com.qldv.service.TripService;
import java.io.IOException;
import java.util.Date;
import java.sql.Time;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Trip> getDeparturedayTrips(Date kw, int id) {
        return this.tripRepository.getDeparturedayTrips(kw, id);
    }

    @Override
    public List<Trip> findById(int i) {
        return this.tripRepository.findById(i);
    }

    @Override
    public List<Trip> getTrips(Map<String, String> params, int start, int limit) {
        return this.tripRepository.getTrips(params, start, limit);
    }

    @Override
    public List<Trip> getListNav(int start, int limit) {
        return this.tripRepository.getListNav(start, limit);
    }

    @Override
    public Trip addTrip(Trip t) {
        t.setActive(Boolean.TRUE);
        return this.tripRepository.addTrip(t);
    }

    @Override
    public boolean editTrip(Trip t) {
        return this.tripRepository.editTrip(t);
    }

    @Override
    public boolean deleteTrip(int id) {
        try {
            this.tripRepository.deleteTrip(id);

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int totalItem() {
        return this.tripRepository.totalItem();
    }

    @Override
    public Trip tripById(int tripId) {
        return this.tripRepository.tripById(tripId);
    }

    @Override
    public List<Trip> getTrips(String kw) {
        return this.tripRepository.getTrips(kw);
    }

    @Override
    public Route getRouteByTrip(int id) {
        return this.tripRepository.getRouteByTrip(id);
    }

    @Override
    public List<Trip> getTrips() {
        return this.tripRepository.getTrips();
    }

    @Override
    public List<Trip> tripComment() {
        return this.tripRepository.tripComment();
    }

}
