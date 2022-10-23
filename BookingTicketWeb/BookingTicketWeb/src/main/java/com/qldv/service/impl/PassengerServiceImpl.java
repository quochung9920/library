/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.service.impl;

import com.qldv.pojo.Passengercar;
import com.qldv.repository.PassengerRepository;
import com.qldv.service.PassengerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class PassengerServiceImpl implements PassengerService{
    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public List<Passengercar> getPassengercars(String kw) {
        return this.passengerRepository.getPassengercars(kw);
    }

    @Override
    public int totalItem() {
        return this.passengerRepository.totalItem();
    }

    @Override
    public Passengercar getById(int id) {
         return this.passengerRepository.getById(id);
    }
    
    @Override
    public int getNumberSeat(int tripId) {
        return this.passengerRepository.getNumberSeat(tripId);
    }
    
    
}
