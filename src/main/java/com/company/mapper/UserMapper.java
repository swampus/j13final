package com.company.mapper;

import com.company.dto.UserDTO;
import com.company.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User fromDTO(UserDTO userDTO){
        User user = new User();
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setFavoriteBook(userDTO.getFavoriteBook());
        user.setId(userDTO.getId());
        user.setPersonalCode(userDTO.getPersonalCode());
        user.setUsername(userDTO.getUsername());
        return user;
    }

    public UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setFavoriteBook(user.getFavoriteBook());
        userDTO.setId(user.getId());
        userDTO.setPersonalCode(user.getPersonalCode());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

}
