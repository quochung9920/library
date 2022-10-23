/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.service.impl;

import com.qldv.pojo.Driver;
import com.qldv.repository.DriverRepository;
import com.qldv.service.DriverService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<Driver> getDrivers(Map<String, String> params, int start, int limit) {
        return this.driverRepository.getDrivers(params, start, limit);
    }

    @Override
    public List<Driver> getListNav(int start, int limit) {
        return this.driverRepository.getListNav(start, limit);
    }

    @Override
    public boolean addDriver(Driver d) {
        return this.driverRepository.addDriver(d);
    }

    @Override
    public boolean editDriver(Driver d) {
        return this.driverRepository.editDriver(d);
    }

    @Override
    public boolean deleteDriver(int id) {
        return this.driverRepository.deleteDriver(id);
    }

    @Override
    public int totalItem() {
        return this.driverRepository.totalItem();
    }

    @Override
    public Driver findById(int driverId) {
         return this.driverRepository.findById(driverId);
    }

    @Override
    public Driver add(String userIdDriver, String identityCard, String address, String dateOfBirth, String license) {
        return this.driverRepository.add(userIdDriver, identityCard, address, dateOfBirth, license);
    }

    @Override
    public Driver addD(Driver driver) {
        return this.driverRepository.addD(driver);
    }

}
