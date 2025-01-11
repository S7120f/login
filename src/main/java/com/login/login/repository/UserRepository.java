package com.login.login.repository;

import org.springframework.data.repository.CrudRepository;

import com.dto.UserDto;
import com.login.login.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

    public User findByUsername (String username); // hitta användare via användarnamn

    User save(UserDto userDto);
    
}
