package com.wangningbo.dao;

import com.wangningbo.pojo.Comment;

import java.util.List;

/**
 * @Author wangningbo
 * @Date 2021/5/22 20:27
 */

public interface CommentDao {
    void insertComment(Comment comment);
    List<Comment> findCommentByIid(String iid);
}
