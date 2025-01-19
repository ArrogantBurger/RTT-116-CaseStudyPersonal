package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long>{
    User findById(Integer id);
    User findByEmailIgnoreCase(String email);
    User findByUsernameIgnoreCase(String username);
}
