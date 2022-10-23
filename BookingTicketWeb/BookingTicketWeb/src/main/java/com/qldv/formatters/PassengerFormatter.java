/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.formatters;

import com.qldv.pojo.Passengercar;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class PassengerFormatter implements Formatter<Passengercar>{
     @Override
    public String print(Passengercar obj, Locale locale) {
        return String.valueOf(obj.getId());
    }

    @Override
    public Passengercar parse(String text, Locale locale)
            throws ParseException {
        Passengercar r = new Passengercar();
        r.setId(Integer.parseInt(text));
        return r;
    }
}
