package com.casestudy.webapp.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@PreAuthorize("isAuthenticated()")
@Slf4j
@Controller
public class UserController {
    @GetMapping("/dashboard/profile")
    public ModelAndView userProfile() {
        ModelAndView response = new ModelAndView("dashboard/userProfile");
        response.setViewName("dashboard/userProfile");
        return response;
    }


}