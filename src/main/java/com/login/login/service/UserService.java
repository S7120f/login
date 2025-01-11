package com.login.login.service;

import com.dto.UserDto;
import com.login.login.model.User;

public interface UserService {
    User findByUsername(String username);
    
    User findByEmail(String email);


    User save(UserDto userDto);
}
