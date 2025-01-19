package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.UserDAO;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserDAO userDao;

    // this get mapping is called by spring security when a secure resource is requested
    // needs to match the spring security configuration  .loginPage method
    @GetMapping("/login")
    public ModelAndView theLoginPage() {
        ModelAndView response = new ModelAndView();

        response.setViewName("login/loginPage");

        return response;
    }

    @GetMapping("/signup")
    public ModelAndView signup() {
        ModelAndView response = new ModelAndView();

        response.setViewName("login/signupPage");

        return response;
    }
}