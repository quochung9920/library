/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.service;

import com.qldv.pojo.Passengercar;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface PassengerService {

    List<Passengercar> getPassengercars(String kw);
    
    int totalItem();
    
    Passengercar getById(int id);
    
    int getNumberSeat(int tripId);
}
