package com.example.render_springboot_neon.services.imp;

import com.example.render_springboot_neon.Dto.UserDto;
import com.example.render_springboot_neon.Mapper.UserMapper;
import com.example.render_springboot_neon.entity.User;
import com.example.render_springboot_neon.exceptions.notFoudException;
import com.example.render_springboot_neon.repository.UserRepository;
import com.example.render_springboot_neon.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new notFoudException("no user with the id: "+ userId));

        return userMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(user -> userMapper.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId).orElseThrow(()->new notFoudException("no such user with id: "+ userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setLastName(userDto.getLastName());

        User updateUser = userRepository.save(user);
        return userMapper.mapToUserDto(updateUser);
    }

    @Override
    public String deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new notFoudException("no such user with id: "+ userId));
        userRepository.delete(user);

        return "user: "+userId+ " delete correctly ";
    }


}
