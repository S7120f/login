package com.login.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.UserDto;
import com.login.login.model.User;
import com.login.login.service.ProductService;
import com.login.login.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {


        @Autowired
    private final UserService userService;
    private final ProductService productService;

    public UserController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
        
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "home";
    }



    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new UserDto(null, null, null, null, null));

        return "/register";
    }

    @PostMapping("/register")
    public String registerSave(@ModelAttribute("user") UserDto userDto, Model model) {
        User userByUsername = userService.findByUsername(userDto.getUsername());
        User userByEmail = userService.findByEmail(userDto.getEmail());

       if (userByUsername != null) {
        model.addAttribute("Userexist", "Användarnamn upptagen");
        return "register";
       }

       if (userByEmail != null) {
        model.addAttribute("Emailexist", "E-postadress upptagen");
        return "register";
       } 
       
        userService.save(userDto);
        return "redirect:/"; // Omdirigera till inloggningssidan efter registrering
    }

}

