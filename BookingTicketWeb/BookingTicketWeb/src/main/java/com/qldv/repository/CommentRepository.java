/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.repository;

import com.qldv.pojo.Comment;
import com.qldv.pojo.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CommentRepository {

    boolean deleteComment(int tripId);

    List<Comment> getCommentsByTripId(int tripId, int page);

    long countTrip(int tripId);

    Comment addComment(String content, int tripId, User user);
}
