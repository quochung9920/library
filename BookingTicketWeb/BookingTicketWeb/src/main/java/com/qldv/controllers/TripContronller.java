/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.Trip;
import com.qldv.service.RouteService;
import com.qldv.service.TicketDetailService;
import com.qldv.service.TripService;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author dieuh
 */
@Controller
public class TripContronller {

    @Autowired
    private TripService tripService;
    

    @RequestMapping("/trip/{routeId}")
    public String trip(Model model, @PathVariable("routeId") int routeId, @ModelAttribute(value = "trip") Trip trip, @RequestParam(required = false) Map<String, String> params) {
       
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fromDate = null;
        String from = params.getOrDefault("kw", null);
        if(from != null)
            try {
                fromDate = f.parse(from);
        } catch (ParseException ex) {
            Logger.getLogger(TripContronller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model.addAttribute("tripDeparturedays", this.tripService.getDeparturedayTrips(fromDate, routeId));
        
        return "trip";
    }
    
}
