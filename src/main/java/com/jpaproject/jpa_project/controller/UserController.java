package com.jpaproject.jpa_project.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jpaproject.jpa_project.model.User;
import com.jpaproject.jpa_project.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class UserController {
    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;
    
  

    public UserController(UserRepository repository, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return this.repository.findAll();
    }
    

    @PostMapping("/register")
    public User setUser(@RequestBody User user) {
        return this.repository.save(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        org.springframework.security.core.Authentication authentication = this.authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        // var u = this.repository.findByUsername(user.getUsername());
        if(authentication.isAuthenticated()){
            return "78966552447788899987293863";
        }
           
        return "Login Failed";
    }
    
    
}
