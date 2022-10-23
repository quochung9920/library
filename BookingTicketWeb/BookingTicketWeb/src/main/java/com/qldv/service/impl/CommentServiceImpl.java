/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.service.impl;

import com.qldv.pojo.Comment;
import com.qldv.pojo.Trip;
import com.qldv.pojo.User;
import com.qldv.repository.CommentRepository;
import com.qldv.repository.TripRepository;
import com.qldv.service.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dieuh
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getCommentsByTripId(int tripId, int page) {
        return this.commentRepository.getCommentsByTripId(tripId, page);
    }

    @Override
    public long countTrip(int tripId) {
        return this.commentRepository.countTrip(tripId);
    }

    @Override
    public Comment addComment(String content, int tripId, User user) {
        return this.commentRepository.addComment(content, tripId, user);
    }

}
