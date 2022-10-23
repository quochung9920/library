/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.formatters;

import com.qldv.pojo.User;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class UserFormatter implements Formatter<User>{
    @Override
    public String print(User obj, Locale locale) {
        return String.valueOf(obj.getId());
    }

    @Override
    public User parse(String text, Locale locale)
            throws ParseException {
        User r = new User();
        r.setId(Integer.parseInt(text));
        return r;
    }
}
