package com.example.render_springboot_neon.controllers;


import com.example.render_springboot_neon.Dto.UserDto;
import com.example.render_springboot_neon.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")

public class UserController {
    private UserService userService;

        // create user end poit
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto saveUser = userService.createUser(userDto);
        return ResponseEntity.ok(saveUser);
    }

    // get user end poit
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser (@PathVariable("id") Long userId){
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok(userDto);
    }
    // get all end poit
    @GetMapping
    public  ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtoList = userService.getAllUsers();
        return  ResponseEntity.ok(userDtoList);
    }
    // update user end poit
    @PutMapping("{id}")
    public  ResponseEntity<UserDto> updateUser(@PathVariable("id")  Long userId, @RequestBody UserDto userDto){
        UserDto updateUser = userService.updateUser(userId, userDto);
        return  ResponseEntity.ok(updateUser);

    }

    // delete user end poit
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteUser (@PathVariable("id") Long userId){
        String message = userService.deleteUser(userId);
        return ResponseEntity.ok(message);

    }



}
