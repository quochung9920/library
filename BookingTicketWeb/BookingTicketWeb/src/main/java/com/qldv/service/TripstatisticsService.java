/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author dieuh
 */

public interface TripstatisticsService {
   List<Object[]> tripStatsByRouteId();

    List<Object[]> tripStats(String kw, Date fromDate, Date toDate);

    List<Object[]> tripMonthStats( Date fromDate, Date toDate);

    List<Object[]> tripYearStats( Date fromDate, Date toDate);

    List<Object[]> tripQuarterStats( Date fromDate, Date toDate);
}
