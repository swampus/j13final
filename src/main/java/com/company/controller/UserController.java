package com.company.controller;

import com.company.dto.UserDTO;
import com.company.mapper.UserMapper;
import com.company.model.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rest/User.svc")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/user")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userMapper.toDTO(userService
                .saveUser(userMapper.fromDTO(userDTO)));
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/user/favorite_book({favoriteBook})")
    public List<UserDTO> getByFavoriteBook(@PathVariable("favoriteBook")
                                                       String favoriteBook) {
        List<User> users = userService.getByFavoriteBook(favoriteBook);
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
}
