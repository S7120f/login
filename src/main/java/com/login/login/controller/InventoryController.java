package com.login.login.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import jakarta.servlet.http.HttpServletResponse;

@Controller
// @RequestMapping("/inventory")
public class InventoryController {


    @GetMapping("/inventory") // istället för att störa Spring Securitys standardinställningar hanterar vi omdirigering i controllen
    public String inventoryPage(@AuthenticationPrincipal UserDetails user, HttpServletResponse response) throws Exception{
        if (user == null){
            //Om använder inte är inloggad, indirigera till startsidan
            response.sendRedirect("/");   
            return null;
        }

        // om användaren är inloggad, visa inventory sidan
        return "inventory"; // retunera inventory sidan
    }
    
}
