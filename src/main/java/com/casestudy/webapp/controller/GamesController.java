package com.casestudy.webapp.controller;
import com.casestudy.webapp.database.dao.SpeedrunDAO;
import com.casestudy.webapp.database.entity.Game;
import com.casestudy.webapp.database.dao.GameDAO;
import com.casestudy.webapp.database.entity.Speedrun;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class GamesController {

    @Autowired
    private GameDAO gameDao;

    @Autowired
    private SpeedrunDAO speedrunDao;

    @GetMapping("/games")
    public ModelAndView gamesMain() {
        ModelAndView response = new ModelAndView("games/gamesPage");
        response.setViewName("games/gamesPage");

        List<Game> latestGames = gameDao.findAlphabetizedGames();
        response.addObject("latestGameListKey", latestGames);

        return response;
    }

    // dynamic page mapping, intended to be a template that pulls all information on a specific title
    @GetMapping("/games/page/{gameAbbr}")
    public ModelAndView gamesDynamic(@PathVariable String gameAbbr) {
        System.out.println(gameAbbr);
        ModelAndView response = new ModelAndView("games/gamesPageDetails");
        response.setViewName("games/gamesPageDetails");

        List<Game> titleGame = gameDao.findByAbbrIgnoreCase(gameAbbr);
        response.addObject("titleGameKey", titleGame);

        List<Game> latestGames = gameDao.findAlphabetizedGames();
        response.addObject("latestGameListKey", latestGames);

        if (titleGame.size() > 0) {
            List<Speedrun> gameSpeedruns = titleGame.get(0).getSpeedruns();
            response.addObject("titleSpeedrunsKey", gameSpeedruns);
        }


        return response;
    }


}