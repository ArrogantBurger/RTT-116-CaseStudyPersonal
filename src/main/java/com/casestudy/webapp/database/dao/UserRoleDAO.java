package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.User;
import com.casestudy.webapp.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    UserRole findById(Integer id);
    List<UserRole> findByUserId(Integer userId);

}