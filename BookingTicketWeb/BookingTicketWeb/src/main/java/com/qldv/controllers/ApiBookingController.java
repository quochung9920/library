/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.Seat;
import com.qldv.pojo.User;
import com.qldv.service.TicketDetailService;
import com.qldv.service.UserService;
import com.qldv.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiBookingController {

    @Autowired
    private TicketDetailService ticketDetailService;

    @Autowired
    private UserService userDetailService;

     @PostMapping("/api/reservation")
    public int addTicketDetail(@RequestBody Seat params, HttpSession session) {
        Map<Integer, Seat> seat = (Map<Integer, Seat>) session.getAttribute("seat");
        if (seat == null) {
            seat = new HashMap<>();
        }

        int seatId = params.getId();

        if (seat.containsKey(seatId) == true) {
            seat.get(seatId);
        } else {
            seat.put(seatId, params);
        }

        session.setAttribute("seat", seat);

        return Utils.count(seat);
    }

    @DeleteMapping(value = "/api/reservation/delete/{seatId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Map<String, String>> deleteSeatItem(@PathVariable(value = "seatId") int seatId,
            HttpSession session) {
        Map<Integer, Seat> seat = (Map<Integer, Seat>) session.getAttribute("seat");
        if (seat != null && seat.containsKey(seatId)) {
            seat.remove(seatId);
            session.setAttribute("seat", seat);
        }
        return new ResponseEntity<>(Utils.seatStats(seat), HttpStatus.OK);
    }

    @PostMapping(value = "/api/pay")
    public HttpStatus pay(HttpSession session, @RequestBody Map<String, String> params,
            HttpServletRequest request, Authentication au) {
        User u = this.userDetailService.getUsers(au.getName()).get(0);

        String method = params.get("method");

        if (this.ticketDetailService.addReceipt((Map<Integer, Seat>) session.getAttribute("seat"), u.getId(), method) == true) {
            session.removeAttribute("seat");
            return HttpStatus.OK;
        }

        return HttpStatus.BAD_REQUEST;
    }
    
//    @PostMapping(value = "/api/pay")
//    public HttpStatus payMomo(HttpSession session, @RequestBody Map<String, String> params,
//            HttpServletRequest request, Authentication au) {
//        User u = this.userDetailService.getUsers(au.getName()).get(0);
//
//        String method = params.get("method");
//
//        if (this.ticketDetailService.addReceipt((Map<Integer, Seat>) session.getAttribute("seat"), u.getId(), method) == true) {
//            session.removeAttribute("seat");
//            return HttpStatus.OK;
//        }
//
//        return HttpStatus.BAD_REQUEST;
//    }
}
