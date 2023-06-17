package com.vikas.udemy.mysqldataapp.service;

import com.vikas.udemy.mysqldataapp.dto.UserDto;
import com.vikas.udemy.mysqldataapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto saveUser(UserDto user);
    void deleteUser(Long userId);
    UserDto getUser(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user);
}
