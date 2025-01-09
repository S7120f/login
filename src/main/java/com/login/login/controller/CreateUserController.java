package com.login.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RequestMapping("/register")
public class CreateUserController {

    @GetMapping("/register")
    public String showRegistrationPage() {

        return "/register";
    }

 
    
}
