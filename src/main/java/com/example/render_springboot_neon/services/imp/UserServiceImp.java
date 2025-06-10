package com.example.render_springboot_neon.services.imp;

import com.example.render_springboot_neon.Dto.UserDto;
import com.example.render_springboot_neon.Mapper.UserMapper;
import com.example.render_springboot_neon.entity.User;
import com.example.render_springboot_neon.repository.UserRepository;
import com.example.render_springboot_neon.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {
    private UserMapper userMapper;
   private  UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.maToUser(userDto);
        User saveUser = userRepository.save(user);


        return userMapper.mapToUserDto(saveUser);
    }
}
