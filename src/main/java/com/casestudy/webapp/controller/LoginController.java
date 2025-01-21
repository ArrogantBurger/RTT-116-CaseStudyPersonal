package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.UserDAO;
import com.casestudy.webapp.database.dao.UserRoleDAO;
import com.casestudy.webapp.database.entity.User;
import com.casestudy.webapp.database.entity.UserRole;
import com.casestudy.webapp.form.SignupFormBean;
import com.casestudy.webapp.security.AuthenticatedUserService;
import com.mysql.cj.log.Log;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.Console;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

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
        System.out.println("signup reached");

        return response;
    }

    // WE ARE DOING THIS AS A POST NOT A GET
    @PostMapping("/signupSubmit")
    public ModelAndView signupSubmit(@Valid SignupFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView();

        // could manually check the email from the database and ADD an error to the binding

        if ( bindingResult.hasErrors() ) {
            response.setViewName("login/signupPage");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            System.out.println("Error found in signup!");
        } else {
            User user = new User();

            user.setUsername(form.getUsername());

            // first we need to encrypt the incoming password before saving it to the database
            // the password in the form is in plain text but we want to save to the database encrypted
            String encryptedPassword = passwordEncoder.encode(form.getPassword());
            user.setPassword(encryptedPassword);

            System.out.println("fields set");
            System.out.println("password check: " + encryptedPassword);


            userDao.save(user);

            System.out.println("User saved");

            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleName("USER");

            userRoleDao.save(userRole);

            System.out.println("Roles saved");

            // since this is a new user we can manually authenticate them for the first time
            authenticatedUserService.changeLoggedInUsername(session,form.getUsername(),form.getPassword());

            // redirect
            response.setViewName("redirect:/index");
        }

        return response;
    }
}