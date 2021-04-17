package com.company.service;

import com.company.model.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;

@Component
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User getByPersonalCode(String personalCode) {
        return userRepository.findByPersonalCode(personalCode);
    }

    public List<User> getByFavoriteBook(String favoriteBook) {
        return userRepository.findByFavoriteBookLike("%" + favoriteBook + "%");
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsersByBookName(String bookName) {
        return userRepository.findDistinctByBooksNameLike("%" + bookName + "%");
    }

}
