package com.sparta.jian.libraryproject.controllers;

import com.sparta.jian.libraryproject.entities.UserEntity;
import com.sparta.jian.libraryproject.services.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    UserService userService;

    @GetMapping("/")
    public String goToWelcome(UserEntity userEntity, Authentication authentication){
        return "redirect:/bookPage";
    }

    @GetMapping("/login")
    public String goToLogin() {
        return "login";
    }

    @GetMapping("/welcome")
    public String showWelcomePage(){
        return "welcome";
    }

    @GetMapping("/welcomeAdmin")
    public String showWelcomeAdminPage(){
        return "welcomeAdmin";
    }

    @GetMapping("/welcomeUser")
    public String showWelcomeUserPage(){
        return "welcomeUser";
    }

    @GetMapping("/accessDenied")
    public String showAccessDeniedPage(){
        return "accessDenied";
    }
}
