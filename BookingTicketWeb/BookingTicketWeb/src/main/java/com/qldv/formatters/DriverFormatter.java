/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.formatters;

import com.qldv.pojo.Driver;
import com.qldv.pojo.Trip;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class DriverFormatter implements Formatter<Driver>{
    @Override
    public String print(Driver obj, Locale locale) {
        return String.valueOf(obj.getUserIdDriver());
    }

    @Override
    public Driver parse(String text, Locale locale)
            throws ParseException {
        Driver r = new Driver();
        r.setUserIdDriver(Integer.parseInt(text));
        return r;
    }
}
