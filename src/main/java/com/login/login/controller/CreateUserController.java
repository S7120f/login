package com.login.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateUserController {

    @GetMapping("/register")
    public String showRegistrationPage() {

        return "register";
    }

 
    
}
