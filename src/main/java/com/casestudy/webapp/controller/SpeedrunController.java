package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.CommentDAO;
import com.casestudy.webapp.database.entity.Comment;
import com.casestudy.webapp.database.entity.User;
import com.casestudy.webapp.database.dao.UserDAO;
import com.casestudy.webapp.database.entity.Game;
import com.casestudy.webapp.database.dao.GameDAO;
import com.casestudy.webapp.database.entity.Speedrun;
import com.casestudy.webapp.database.dao.SpeedrunDAO;
import com.casestudy.webapp.form.CreateGameFormBean;
import com.casestudy.webapp.form.CreateSpeedrunFormBean;
import com.casestudy.webapp.security.AuthenticatedUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.lang.Math.*;


@Slf4j
@PreAuthorize("isAuthenticated()")
@Controller

public class SpeedrunController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private GameDAO gameDao;

    @Autowired
    private SpeedrunDAO speedrunDao;

    @Autowired
    private CommentDAO commentDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/games/page/{gameAbbr}/createSpeedrun")
    public ModelAndView speedrunsDynamic(@PathVariable String gameAbbr) {
        System.out.println(gameAbbr);
        ModelAndView response = new ModelAndView("speedrun/createSpeedrun");
        response.setViewName("speedrun/createSpeedrun");

        List<Game> titleGame = gameDao.findByAbbrIgnoreCase(gameAbbr);
        response.addObject("titleGameKey", titleGame);

        if (!titleGame.isEmpty()) {
            List<Speedrun> gameSpeedruns = speedrunDao.findSpeedrunsForGame(titleGame.get(0).getId());
            response.addObject("titleSpeedrunsKey", gameSpeedruns);
        }

        return response;
    }

    @PostMapping("/games/page/{gameAbbr}/createSpeedrunSubmit")
    public ModelAndView createGameSubmit(@Valid CreateSpeedrunFormBean form, BindingResult bindingResult, HttpSession session, @PathVariable String gameAbbr) throws Exception {
        ModelAndView response = new ModelAndView();

        if ( bindingResult.hasErrors() ) {
            response.setViewName("speedrun/createSpeedrun");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            System.out.println("Error found in speedrun submission!");

        } else {

            System.out.println("Speedrun create valid!");

            Speedrun speedrun = new Speedrun();

            List<Game> titleGame = gameDao.findByAbbrIgnoreCase(gameAbbr);
            speedrun.setGame(titleGame.get(0));

            System.out.println(titleGame.get(0).getGameName());

            User loggedInUser = authenticatedUserService.loadCurrentUser();
            speedrun.setUser(loggedInUser);

            System.out.println(loggedInUser.getUsername());

            String[] convertedTime = form.getSpeedrunTime().split(":");
            Integer convertedTimeToInt = 0;
            for (int i = convertedTime.length; i > 0; i--) {
                convertedTimeToInt += Integer.parseInt(convertedTime[i - 1]) * (int)Math.pow(60, convertedTime.length - i);
            }
            speedrun.setSpeedrunTime(convertedTimeToInt);

            System.out.println(convertedTimeToInt);

            String date = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
            speedrun.setDateSubmitted(date);
            System.out.println(date);

            speedrun.setVideoUrl(form.getVideoUrl());

            speedrunDao.save(speedrun);
            System.out.println("saved speedrun");

            response.setViewName("redirect:/games/page/{gameAbbr}");
        }
        return response;
    }

    @GetMapping("/games/page/{gameAbbr}/speedrun/{speedrunId}")
    public ModelAndView speedrunPage(@PathVariable String gameAbbr, @PathVariable Integer speedrunId) {
        System.out.println(gameAbbr);
        ModelAndView response = new ModelAndView("speedrun/speedrunDetails");
        response.setViewName("speedrun/speedrunDetails");

        List<Game> latestGames = gameDao.findLatestGames();
        response.addObject("latestGameListKey", latestGames);
        List<Game> titleGame = gameDao.findByAbbrIgnoreCase(gameAbbr);
        response.addObject("titleGameKey", titleGame);

        if (!titleGame.isEmpty()) {
            List<Speedrun> speedrun = speedrunDao.findById(speedrunId);
            response.addObject("speedrunKey", speedrun);

            List<Comment> speedrunComments = commentDao.findBySpeedrunId(speedrunId);
            response.addObject("commentsKey", speedrunComments);
        }

        return response;
    }

}
