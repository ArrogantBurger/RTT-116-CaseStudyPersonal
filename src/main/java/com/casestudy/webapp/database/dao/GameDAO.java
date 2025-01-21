package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface GameDAO extends JpaRepository<Game, Long>{
    Game findById(Integer id);
    Game findByGameNameIgnoreCase(String gameName);
    List<Game> findByAbbrIgnoreCase(String abbr);

    @Query("SELECT g FROM Game g ORDER BY g.id DESC LIMIT 20")
    List<Game> findLatestGames();

    @Query("SELECT g FROM Game g ORDER BY g.gameName ASC LIMIT 20")
    List<Game> findAlphabetizedGames();

}
