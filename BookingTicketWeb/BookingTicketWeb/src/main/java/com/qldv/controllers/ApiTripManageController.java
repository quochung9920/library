/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.Trip;
import com.qldv.service.EmployeeService;
import com.qldv.service.PassengerService;
import com.qldv.service.RouteService;
import com.qldv.service.TicketDetailService;
import com.qldv.service.TripService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiTripManageController {

    @Autowired
    private TripService tripService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PassengerService passengerService;
    
    @Autowired
    private TicketDetailService ticketDetailService;
    
    @PutMapping(path = "/api/admin/update-image-trip")
    @ResponseStatus(HttpStatus.OK)
    public void updateImageRoute(@RequestBody Map<String, String> params) {
        try {
            String urlImage = params.get("urlImage");
            int id = Integer.parseInt(params.get("id"));

            Trip r = this.tripService.tripById(id);

            r.setImage(urlImage);

            this.tripService.editTrip(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @PostMapping(path = "/api/admin/add-trip", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Trip> addTrip(@RequestBody Map<String, String> params) {
        try {
            String coachname = params.get("coachname");
            String departureday = params.get("departureday");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(departureday);
            String departuretime = params.get("departuretime");
            Date time1 = new SimpleDateFormat("HH:mm:ss").parse(departuretime);
            String arrivaltime = params.get("arrivaltime");
            Date time2 = new SimpleDateFormat("HH:mm:ss").parse(arrivaltime);
            String routeId = params.get("routeId");
            String userIdEmployee = params.get("userIdEmployee");
            String passengercarId = params.get("passengercarId");
            String urlImage = params.get("image");

            Trip newTrip = new Trip();
            newTrip.setCoachname(coachname);
            newTrip.setDepartureday(date);
            newTrip.setDeparturetime(time1);
            newTrip.setArrivaltime(time2);
            newTrip.setRouteId(this.routeService.findById(Integer.parseInt(routeId)));
            newTrip.setUserIdEmployee(this.employeeService.findById(Integer.parseInt(userIdEmployee)));
            newTrip.setPassengercarId(this.passengerService.getById(Integer.parseInt(passengercarId)));
            newTrip.setImage(urlImage);

            Trip t = this.tripService.addTrip(newTrip);

            return new ResponseEntity<>(t, HttpStatus.CREATED);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PutMapping(path = "/api/admin/update-trip")
    @ResponseStatus(HttpStatus.OK)
    public void updateTrip(@RequestBody Map<String, String> params) {
        try {
            String coachname = params.get("coachname");
            String departureday = params.get("departureday");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(departureday);
            String departuretime = params.get("departuretime");
            Date time1 = new SimpleDateFormat("HH:mm:ss").parse(departuretime);
            String arrivaltime = params.get("arrivaltime");
            Date time2 = new SimpleDateFormat("HH:mm:ss").parse(arrivaltime);
            String routeId = params.get("routeId");
            String userIdEmployee = params.get("userIdEmployee");
            String passengercarId = params.get("passengercarId");
            String urlImage = params.get("image");
            String active = params.get("active");
            String id = params.get("id");

            Trip updateTrip = this.tripService.tripById(Integer.parseInt(id));
            updateTrip.setCoachname(coachname);
            updateTrip.setDepartureday(date);
            updateTrip.setDeparturetime(time1);
            updateTrip.setArrivaltime(time2);
            updateTrip.setImage(urlImage);
            updateTrip.setActive(Boolean.valueOf(active));
            updateTrip.setRouteId(this.routeService.findById(Integer.parseInt(routeId)));
            updateTrip.setUserIdEmployee(this.employeeService.findById(Integer.parseInt(userIdEmployee)));
            updateTrip.setPassengercarId(this.passengerService.getById(Integer.parseInt(passengercarId)));

            this.tripService.editTrip(updateTrip);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @PostMapping("/api/trip/countRemain")
    public int countRemainSeat(@RequestBody Map<String, String> params, HttpSession session) {
        String tripId = params.get("tripId");
        
        int count = Math.abs((this.passengerService.getNumberSeat
        (Integer.parseInt(tripId)))-(this.ticketDetailService.countTicketsByTripId(Integer.parseInt(tripId))));

        return count;
    }
}
