package com.example.render_springboot_neon.Mapper;

import com.example.render_springboot_neon.Dto.UserDto;
import com.example.render_springboot_neon.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User maToUser (UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }

    public UserDto mapToUserDto (User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail()
        );
    }
}
