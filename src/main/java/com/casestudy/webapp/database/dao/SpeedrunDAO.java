package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Speedrun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeedrunDAO extends JpaRepository<Speedrun, Long>{
    Speedrun findById(Integer id);
}
