package org.example.library.jbel.service;

//import com.example.registrationlogindemo.dto.UserDto;
//import com.example.registrationlogindemo.entity.User;

import org.example.library.jbel.dto.UserDto;
import org.example.library.jbel.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
