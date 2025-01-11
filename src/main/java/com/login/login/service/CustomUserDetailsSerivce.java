package com.login.login.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.login.repository.UserRepository;

@Service
public class CustomUserDetailsSerivce implements UserDetailsService{
    

    private final UserRepository userRepository;

    public CustomUserDetailsSerivce(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.login.login.model.User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Hittade ingen användare");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .build();
    }
    
}
