package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDAO extends JpaRepository<Comment, Long>{
    Comment findById(Integer id);
}
