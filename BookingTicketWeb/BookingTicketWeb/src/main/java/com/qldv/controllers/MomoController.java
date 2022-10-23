/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dieuh
 */
@Controller
public class MomoController {
   @RequestMapping("/paybymomo")
    public void viewPayMomo() {
       return;
    } 
}