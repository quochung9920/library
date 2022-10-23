/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.Route;
import com.qldv.pojo.Seat;
import com.qldv.pojo.Trip;
import com.qldv.pojo.User;
import com.qldv.service.TicketDetailService;
import com.qldv.service.TripService;
import com.qldv.service.UserService;
import com.qldv.utils.Utils;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class BookingTicketController {

    @Autowired
    private TicketDetailService ticketDetailService;

    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userDetailService;

    @RequestMapping("/reservation/{tripId}")
    public String BookingTicket(Model model, @PathVariable("tripId") int tripId) {
        Trip t = tripService.tripById(tripId);
        Route r = t.getRouteId();
        long price = r.getPrice();
        List<Seat> newSeatA = ticketDetailService.getSeat("A");
        List<Seat> newSeatB = ticketDetailService.getSeat("B");
        List<Object[]> occupiedSeats = ticketDetailService.findTicketsByTripId(tripId);
        for (Seat a : newSeatA) {
            for (Object o : occupiedSeats) {
                if (a.getId() == Integer.parseInt(o.toString())) {
                    a.setActive(1);
                }
            }
        }
        for (Seat b : newSeatB) {
            for (Object o : occupiedSeats) {
                if (b.getId() == Integer.parseInt(o.toString())) {
                    b.setActive(1);
                }
            }
        }
        model.addAttribute("listSeatA", newSeatA);
        model.addAttribute("listSeatB", newSeatB);
        model.addAttribute("tripId", tripId);
        model.addAttribute("pasCar", t.getPassengercarId());
        model.addAttribute("price", price);
        return "reservation";
    }

    @RequestMapping("/reservation/{tripId}/confirm-seat")
    public String confirmPage(HttpSession session, @PathVariable("tripId") int tripId, Model model) {

        Map<Integer, Seat> seat = (Map<Integer, Seat>) session.getAttribute("seat");
        if (seat != null) {
            model.addAttribute("seat", seat.values());
        } else {
            model.addAttribute("seat", null);
        }
        model.addAttribute("tripId", tripId);
        model.addAttribute("counter", Utils.count((Map<Integer, Seat>) session.getAttribute("seat")));
        model.addAttribute("seatStats", Utils.seatStats((Map<Integer, Seat>) session.getAttribute("seat")));
        return "confirmseat";
    }

    @RequestMapping("/reservation/{tripId}/confirm-seat/user-information")
    public String billPage(HttpSession session, @PathVariable("tripId") int tripId, Model model,
            HttpServletRequest request, Authentication au) {
        User u = this.userDetailService.getUsers(au.getName()).get(0);
        Trip t = tripService.tripById(tripId);
        Map<Integer, Seat> seat = (Map<Integer, Seat>) session.getAttribute("seat");
        if (seat != null) {
            model.addAttribute("seat", seat.values());
        } else {
            model.addAttribute("seat", null);
        }
        model.addAttribute("counter", Utils.count((Map<Integer, Seat>) session.getAttribute("seat")));
        model.addAttribute("seatStats", Utils.seatStats((Map<Integer, Seat>) session.getAttribute("seat")));
        model.addAttribute("tripId", tripId);
        model.addAttribute("user", u);
        model.addAttribute("trip", t);
        return "bill";
    }
    
    @RequestMapping("/reservation/{tripId}/confirm-seat/user-information/success")
    public String successPage(HttpSession session, @PathVariable("tripId") int tripId, Model model) {
        Map<Integer, Seat> seat = (Map<Integer, Seat>) session.getAttribute("seat");
        if (seat != null) {
            model.addAttribute("seat", seat.values());
        } else {
            model.addAttribute("seat", null);
        }
        model.addAttribute("counter", Utils.count((Map<Integer, Seat>) session.getAttribute("seat")));
        model.addAttribute("seatStats", Utils.seatStats((Map<Integer, Seat>) session.getAttribute("seat")));
        model.addAttribute("tripId", tripId);
        return "successpage";
    }
    
    @RequestMapping("/reservation/{tripId}/confirm-seat/user-information/success-momo")
    public String successPageMomo(HttpSession session, @PathVariable("tripId") int tripId, Model model) {
        Map<Integer, Seat> seat = (Map<Integer, Seat>) session.getAttribute("seat");
        if (seat != null) {
            model.addAttribute("seat", seat.values());
        } else {
            model.addAttribute("seat", null);
        }
        model.addAttribute("counter", Utils.count((Map<Integer, Seat>) session.getAttribute("seat")));
        model.addAttribute("seatStats", Utils.seatStats((Map<Integer, Seat>) session.getAttribute("seat")));
        model.addAttribute("tripId", tripId);
        return "paybymomo";
    }
}
