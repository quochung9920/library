/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository;

import com.qldv.pojo.Driver;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface DriverRepository {

    List<Driver> getDrivers(Map<String, String> params, int start, int limit);

    List<Driver> getListNav(int start, int limit);

    boolean addDriver(Driver d);

    boolean editDriver(Driver d);

    boolean deleteDriver(int id);

    int totalItem();

    Driver findById(int driverId);
    
    Driver add(String userIdDriver, String identityCard, String address, String dateOfBirth, String license);
    
    Driver addD(Driver driver);
}
