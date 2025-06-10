package com.example.render_springboot_neon.services;

import com.example.render_springboot_neon.Dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser (UserDto userDto);
    UserDto getUser (Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser (Long userId, UserDto userDto);
    String deleteUser (Long userId);

}
