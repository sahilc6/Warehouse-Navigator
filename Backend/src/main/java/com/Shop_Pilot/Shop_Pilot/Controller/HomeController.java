package com.Shop_Pilot.Shop_Pilot.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")  // maps to root URL
    public String home() {
        return "Hello, Shop Pilot!";
    }
}
