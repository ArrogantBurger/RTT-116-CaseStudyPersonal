package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDAO extends JpaRepository<Comment, Long>{
    Comment findById(Integer id);
    List<Comment> findBySpeedrunId(Integer speedrunId);
}
