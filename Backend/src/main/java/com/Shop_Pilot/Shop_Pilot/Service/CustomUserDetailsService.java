package com.Shop_Pilot.Shop_Pilot.Service;

import org.springframework.stereotype.Service;

import com.Shop_Pilot.Shop_Pilot.Repositories.UserRepository;
import com.Shop_Pilot.Shop_Pilot.models.User;

@Service
public class CustomUserDetailsService {

    private final UserRepository repo;

    public CustomUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    // Method to get email by email (or username if needed)
    public String getEmail(String email) {
        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return user.getEmail();
    }
}
