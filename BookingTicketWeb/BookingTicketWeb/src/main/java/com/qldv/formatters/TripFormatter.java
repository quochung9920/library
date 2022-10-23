/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.formatters;

import com.qldv.pojo.Trip;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class TripFormatter implements Formatter<Trip>{
    @Override
    public String print(Trip obj, Locale locale) {
        return String.valueOf(obj.getId());
    }

    @Override
    public Trip parse(String text, Locale locale)
            throws ParseException {
        Trip r = new Trip();
        r.setId(Integer.parseInt(text));
        return r;
    }

    
}
