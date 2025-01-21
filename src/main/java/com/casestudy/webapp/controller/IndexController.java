package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.GameDAO;
import com.casestudy.webapp.database.dao.SpeedrunDAO;
import com.casestudy.webapp.database.dao.UserDAO;
import com.casestudy.webapp.database.entity.Game;
import com.casestudy.webapp.database.entity.Speedrun;
import com.casestudy.webapp.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Slf4j
@Controller
public class IndexController {

    @Autowired
    private GameDAO gameDao;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private SpeedrunDAO speedrunDao;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("index");
        response.setViewName("index");

        List<Game> latestGames = gameDao.findLatestGames();
        response.addObject("latestGameListKey", latestGames);

        return response;
    }

    @GetMapping("")
    public ModelAndView indexTwo() {
        ModelAndView response = new ModelAndView("index");
        response.setViewName("index");

        List<Game> latestGames = gameDao.findLatestGames();
        response.addObject("latestGameListKey", latestGames);

        return response;
    }
}
