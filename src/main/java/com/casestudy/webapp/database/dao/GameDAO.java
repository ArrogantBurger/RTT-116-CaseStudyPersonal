package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface GameDAO extends JpaRepository<Game, Long>{
    Game findById(Integer id);
    Game findByGameNameIgnoreCase(String gameName);
    Game findByAbbrIgnoreCase(String abbr);


}
