package com.casestudy.webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class GamesController {
    @GetMapping("/games")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("games/games");
        response.setViewName("games/games");
        return response;
    }
}