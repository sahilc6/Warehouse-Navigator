package com.Shop_Pilot.Shop_Pilot.Controller;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000") 
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

>>>>>>> 47dceb3195e302200452e27fca3fa60c95fb6d3a
@RestController
public class HomeController {
    @GetMapping("/")  // maps to root URL
    public String home() {
        return "Hello, Shop Pilot!";
    }
}
