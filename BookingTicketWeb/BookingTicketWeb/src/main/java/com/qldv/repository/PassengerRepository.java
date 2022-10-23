/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository;

import com.qldv.pojo.Passengercar;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface PassengerRepository {

    Passengercar getById(int id);

    List<Passengercar> getPassengercars(String kw);
    
    int totalItem();
    
    int getNumberSeat(int tripId);
}
