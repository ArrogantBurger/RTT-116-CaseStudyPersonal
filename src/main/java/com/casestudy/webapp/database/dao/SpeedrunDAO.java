package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Game;
import com.casestudy.webapp.database.entity.Speedrun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeedrunDAO extends JpaRepository<Speedrun, Long>{
    Speedrun findById(Integer id);
    List<Speedrun> findByGameId(Integer gameId);
}
