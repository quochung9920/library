/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.formatters;

import com.qldv.pojo.Employee;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class EmployeeFormatter implements Formatter<Employee>{
    @Override
    public String print(Employee obj, Locale locale) {
        return String.valueOf(obj.getUserIdEmployee());
    }

    @Override
    public Employee parse(String text, Locale locale)
            throws ParseException {
        Employee r = new Employee();
        r.setUserIdEmployee(Integer.parseInt(text));
        return r;
    }
}
