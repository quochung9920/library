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
import com.qldv.service.TripService;
import com.qldv.service.UserService;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
//@ControllerAdvice
@RequestMapping("admin/trips")
public class TripManageController {

    @Autowired
    private TripService tripService;
    
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private UserService userService;

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/list")
    public String viewTripList(ModelMap mm) {
        mm.addAttribute("listTrips", tripService.getListNav(0, 8));
        mm.addAttribute("totalItem", Math.ceil(tripService.totalItem()) / 8);
        return "trips";
    }

    @GetMapping("/list/{page}")
    public String viewTripListByPage(ModelMap mm, @PathVariable("page") int page) {
        mm.addAttribute("listTrips", tripService.getListNav((page - 1) * 8, 8));
        mm.addAttribute("totalItem", Math.ceil(tripService.totalItem()) / 8);
        return "trips";
    }

    @GetMapping("/addtrip")
    public String viewTripNew(ModelMap mm) {
        mm.addAttribute("trip", new Trip());
        mm.addAttribute("routes", routeService.getRoutes());
        mm.addAttribute("users", userService.getUsers("Employee"));
        mm.addAttribute("pcars", passengerService.getPassengercars(""));
        return "addtrip";
    }

    @GetMapping("/edittrip/{tripId}")
    public String viewTripEdit(ModelMap mm, @PathVariable("tripId") int tripId) {
        mm.addAttribute("trip", tripService.tripById(tripId));
        mm.addAttribute("routes", routeService.getRoutes());
        mm.addAttribute("users", userService.getUsers("Employee"));
        mm.addAttribute("pcars", passengerService.getPassengercars(""));
        return "updatetrip";
    }
    
    @GetMapping("/edittrip/image/{tripId}")
    public String viewTripEditImage(ModelMap mm, @PathVariable("tripId") int tripId) {
        mm.addAttribute("trip", tripService.tripById(tripId));
        return "edit_image_trip";
    }

    @PostMapping("/edittrip")
    public String doUpdateTrip(ModelMap mm, @RequestParam(required = false) Map<String, String> params,
            @ModelAttribute(value = "trip") @Valid Trip trip, BindingResult rs) throws ParseException {
        String ms = "";
        if (rs.hasErrors()) {
            ms += "Đã có lỗi xảy ra! Vui lòng thử lại";
            mm.addAttribute("ms", ms);
            return "updatetrip";
        }

        String date = params.get("departureday");
        String time1 = params.get("departuretime");
        String time2 = params.get("arrivaltime");

        Date departureday = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Date departuretime = new SimpleDateFormat("HH:mm:ss").parse(time1);
        Date arrivaltime = new SimpleDateFormat("HH:mm:ss").parse(time2);

        trip.setDepartureday(departureday);
        trip.setDeparturetime(departuretime);
        trip.setArrivaltime(arrivaltime);

        if (this.tripService.editTrip(trip) == true) {
            viewTripList(mm);
            return "redirect:/admin/trips/list";
        }
        return "updatetrip";

    }

    @PostMapping("/savetrip")
    public String viewTripSave(ModelMap mm, @RequestParam Map<String, String> params,
            @ModelAttribute(value = "trip") @Valid Trip trip, BindingResult rs) throws ParseException {
        String ms = "";
        if (rs.hasErrors()) {
            ms += "Đã có lỗi xảy ra! Vui lòng thử lại";
            mm.addAttribute("ms", ms);
            return "addtrip";
        }

        String date = params.get("departureday");
        String time1 = params.get("departuretime");
        String time2 = params.get("arrivaltime");

        Date departureday = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Date departuretime = new SimpleDateFormat("HH:mm:ss").parse(time1);
        Date arrivaltime = new SimpleDateFormat("HH:mm:ss").parse(time2);

        trip.setDepartureday(departureday);
        trip.setDeparturetime(departuretime);
        trip.setArrivaltime(arrivaltime);

        this.tripService.addTrip(trip);
        viewTripList(mm);
        return "redirect:/admin/trips/list";
    }

    @RequestMapping("/deletetrip/{tripId}")
    public String viewTripRemove(ModelMap mm, @PathVariable("tripId") int tripId) {
        tripService.deleteTrip(tripId);
        viewTripList(mm);
        return "trips";
    }

    @GetMapping("/search")
    public String search(@RequestParam Map<String, String> params, ModelMap mm) {
        if (params.get("kw").equals("")) {
            return "redirect:/admin/trips/list";
        }
        mm.addAttribute("listTrips", tripService.getTrips(params, 0, 8));
        mm.addAttribute("totalItem", routeService.countItem(tripService.getTrips(params, 0, 8)) / 8);
        return "trips";
    }

}
