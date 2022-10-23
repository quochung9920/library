/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.utils;

import com.qldv.pojo.Seat;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Utils {

//    public static int count(Seat seat) {
//        int q = 0;
//        if (seat != null) {
//            q += seat.getQuantity();
//        }
//        return q;
//    }

    public static int count(Map<Integer, Seat> seat) {
        int q = 0;
        if (seat != null) {
            for (Seat s : seat.values()) {
                q += s.getQuantity();
            }
        }
        return q;
    }
    
    public static Map<String, String> seatStats(Map<Integer, Seat> seat) {
        Long a =0l;
        int q = 0;
        
        if (seat != null)
            for (Seat s : seat.values()) {
                q += s.getQuantity();
                a += s.getQuantity()*s.getPrice();
            }
        Map<String, String> kq = new HashMap<>();
        
        kq.put("counter", String.valueOf(q));
        kq.put("amount", String.valueOf(a));
        
        return kq;
    }
//    public static Map<String, String> seatStats(Seat s) {
//        Long a = 0l;
//        int q = 0;
//
//        q += s.getQuantity();
//        a += s.getQuantity() * s.getPrice();
//        Map<String, String> kq = new HashMap<>();
//
//        kq.put("counter", String.valueOf(q));
//        kq.put("amount", String.valueOf(a));
//
//        return kq;
//    }
}
