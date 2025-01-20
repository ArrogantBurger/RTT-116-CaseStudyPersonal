package com.casestudy.webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class GamesController {
    @GetMapping("/games")
    public ModelAndView gamesMain() {
        ModelAndView response = new ModelAndView("games/gamesPage");
        response.setViewName("games/gamesPage");
        return response;
    }

    @GetMapping("/games/**")
    public ModelAndView gamesDynamic() {
        ModelAndView response = new ModelAndView("games/gamesPage");
        response.setViewName("games/gamesPage");
        return response;
    }
}