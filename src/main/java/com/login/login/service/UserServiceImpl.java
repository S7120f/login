package com.login.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dto.UserDto;
import com.login.login.model.User;
import com.login.login.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

   
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User(
            userDto.getFirstName(),
            userDto.getLastName(),
            userDto.getEmail(),
            userDto.getUsername(),
            passwordEncoder.encode(userDto.getPassword())
        
        );

        return userRepository.save(user);
    }

    
}
