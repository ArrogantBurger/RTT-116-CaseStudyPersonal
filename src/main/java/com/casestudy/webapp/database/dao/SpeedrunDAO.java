package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Game;
import com.casestudy.webapp.database.entity.Speedrun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpeedrunDAO extends JpaRepository<Speedrun, Long>{
    List<Speedrun> findById(Integer id);
    List<Speedrun> findByGameId(Integer gameId);

    @Query("SELECT s FROM Speedrun s WHERE s.gameId = :gameId ORDER BY s.speedrunTime DESC LIMIT 20")
    List<Speedrun> findSpeedrunsForGame(Integer gameId);
}
