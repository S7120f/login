package com.login.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @RequestMapping("/inventory")
public class InventoryController {


    @GetMapping("/inventory")
    public String inventoryPage(){
        return "inventory";
    }
    
}
