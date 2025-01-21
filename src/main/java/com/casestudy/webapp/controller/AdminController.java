package com.casestudy.webapp.controller;
import com.casestudy.webapp.database.dao.GameDAO;
import com.casestudy.webapp.form.CreateGameFormBean;
import com.casestudy.webapp.security.AuthenticatedUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;




@Slf4j
@PreAuthorize("hasAuthority('ADMIN')")
@Controller
public class AdminController {

    @Autowired
    private GameDAO gameDAO;

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
    public ModelAndView createGameSubmit(@Valid CreateGameFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView();

        // could manually check the game from the database and ADD an error to the binding

        if ( bindingResult.hasErrors() ) {
            response.setViewName("admin/createGame");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            System.out.println("Error found in game create!");
        } else {
            System.out.println("Game create valid!");




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
