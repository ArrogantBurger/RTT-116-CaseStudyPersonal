package com.casestudy.webapp.controller;
import com.casestudy.webapp.database.entity.Game;
import com.casestudy.webapp.database.dao.GameDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class GamesController {

    @Autowired
    private GameDAO gameDao;

    @GetMapping("/games")
    public ModelAndView gamesMain() {
        ModelAndView response = new ModelAndView("games/gamesPage");
        response.setViewName("games/gamesPage");
        return response;
    }

    // dynamic page mapping, intended to be a template that pulls all information
    // similar to a search result page
    @GetMapping("/games/{gameAbbr}")
    public ModelAndView gamesDynamic(@PathVariable String gameAbbr) {
        ModelAndView response = new ModelAndView("games/gamesPageDetails");
        response.setViewName("games/gamesPageDetails");

        Game game = gameDao.findByAbbrIgnoreCase(gameAbbr);



        return response;
    }


}