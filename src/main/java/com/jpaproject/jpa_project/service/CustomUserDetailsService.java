package com.jpaproject.jpa_project.service;

import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import com.jpaproject.jpa_project.CustomUserDetails;
import com.jpaproject.jpa_project.model.User;
import com.jpaproject.jpa_project.repository.UserRepository;

@Controller
public class CustomUserDetailsService  implements UserDetailsService{
    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user = this.userRepository.findByUsername(username);
        if(Objects.isNull(user)) {
            throw new UnsupportedOperationException("User not found");
        }
        return new CustomUserDetails(user);
    }
    
}
