/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.Comment;
import com.qldv.pojo.User;
import com.qldv.service.CommentService;
import com.qldv.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dieuh
 */
@RestController

public class ApiCommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userDetailService;
    
    @PostMapping(path = "/comment", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Comment> addComment(HttpSession sesion, HttpServletRequest request, HttpServletResponse response, Authentication a, @RequestBody Map<String, String> params) {
        try {
            User u = this.userDetailService.getUsers(a.getName()).get(0);

            String content = params.get("content");
            int tripId = Integer.parseInt(params.get("trip"));

            Comment c = this.commentService.addComment(content, tripId, u);

            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}