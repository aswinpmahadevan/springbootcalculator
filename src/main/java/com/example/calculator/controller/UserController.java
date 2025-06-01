package com.example.calculator.controller;

import com.example.calculator.model.User;
import com.example.calculator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public void register(
            @RequestParam String username,
            @RequestParam String password,
            HttpServletResponse response
    ) throws IOException {
        if (userRepository.findByUsername(username).isPresent()) {
            // User exists, redirect back to register with error
            response.sendRedirect("/register.html?error=exists");
            return;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        // Redirect to login page after successful registration
        response.sendRedirect("/login.html?registered=true");
    }
}