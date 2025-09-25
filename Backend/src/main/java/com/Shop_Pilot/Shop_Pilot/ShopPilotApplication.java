package com.Shop_Pilot.Shop_Pilot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;   // ✅ MISSING import

@SpringBootApplication
public class ShopPilotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopPilotApplication.class, args);
    }
    
}
