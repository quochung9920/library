/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.service.impl;

import com.qldv.repository.TripstatisticsRepository;
import com.qldv.service.TripstatisticsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dieuh
 */
@Service
public class TripstatisticsServiceImpl implements TripstatisticsService {
   
    @Autowired
    private TripstatisticsRepository tripstatisticsRepository;
    
    /**
     *
     * @return
     */
    @Override
    public List<Object[]> tripStatsByRouteId() {
       return this.tripstatisticsRepository.tripStatsByRouteId();
    }

    @Override
    public List<Object[]> tripStats(String kw, Date fromDate, Date toDate) {
        return this.tripstatisticsRepository.tripStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> tripMonthStats( Date fromDate, Date toDate) {
        return this.tripstatisticsRepository.tripMonthStats( fromDate, toDate);
    }

    @Override
    public List<Object[]> tripYearStats( Date fromDate, Date toDate) {
        return this.tripstatisticsRepository.tripYearStats( fromDate, toDate);
    }

    @Override
    public List<Object[]> tripQuarterStats( Date fromDate, Date toDate) {
        return this.tripstatisticsRepository.tripQuarterStats( fromDate, toDate);
    }
    
}
