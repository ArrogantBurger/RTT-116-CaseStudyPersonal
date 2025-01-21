package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.GameDAO;
import com.casestudy.webapp.database.entity.Game;
import com.casestudy.webapp.form.CreateGameFormBean;
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
import java.util.List;


@Slf4j
@PreAuthorize("hasAuthority('ADMIN')")
@Controller
public class AdminController {

    @Autowired
    private GameDAO gameDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/admin/dashboard")
    public ModelAndView adminDashboard() {
        ModelAndView response = new ModelAndView("admin/adminDashboard");
        response.setViewName("admin/adminDashboard");
        return response;
    }

    @GetMapping("/admin/createGame")
    public ModelAndView createGame() {
        ModelAndView response = new ModelAndView("admin/createGame");
        response.setViewName("admin/createGame");
        return response;
    }

    @PostMapping("admin/createGameSubmit")
    public ModelAndView createGameSubmit(@Valid CreateGameFormBean form, BindingResult bindingResult, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        // could manually check the game from the database and ADD an error to the binding

        if ( bindingResult.hasErrors() ) {
            response.setViewName("admin/createGame");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            System.out.println("Error found in game create!");

        } else {

            System.out.println("Game create valid!");

            Game game = new Game();

            game.setGameName(form.getGameName());
            game.setAbbr(form.getAbbr());
            game.setReleaseYear(form.getReleaseYear());

            System.out.println("fields set");
            System.out.println("uploaded filename = " + form.getUpload().getOriginalFilename() + " size = " + form.getUpload().getSize());

            if (form.getUpload().getSize() != 0) {
                String pathToSave = "./src/main/webapp/pub/images/" + form.getUpload().getOriginalFilename();
                // this is a java utility that will read the file from the upload and write it to the file we created above
                // will not take the entire file into memory
                Files.copy(form.getUpload().getInputStream(), Paths.get(pathToSave), StandardCopyOption.REPLACE_EXISTING);
                // this is the url that we will use to display the image in the browser
                // it is an absolute URL based on the webapp folder as it would be used in the html
                String url = "/pub/images/" + form.getUpload().getOriginalFilename();
                game.setImageUrl(url);
                System.out.println("successful image handling");
            }

            gameDao.save(game);
            System.out.println("saved game");

            response.setViewName("redirect:/admin/createGameSuccess");
        }

        return response;
    }

    @GetMapping("/admin/createGameSuccess")
    public ModelAndView createGameSuccess() {
        ModelAndView response = new ModelAndView("admin/createGameSuccess");
        response.setViewName("admin/createGameSuccess");
        return response;
    }

    @GetMapping("/admin/runApproval")
    public ModelAndView runApproval() {
        ModelAndView response = new ModelAndView("admin/runApproval");
        response.setViewName("admin/runApproval");
        return response;
    }
}
