/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.formatters;

import com.qldv.pojo.Route;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class RouteFormatter implements Formatter<Route> {

    @Override
    public String print(Route obj, Locale locale) {
        return String.valueOf(obj.getId());
    }

    @Override
    public Route parse(String text, Locale locale)
            throws ParseException {
        Route r = new Route();
        r.setId(Integer.parseInt(text));
        return r;
    }
}
