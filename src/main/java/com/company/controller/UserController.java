package com.company.controller;

import com.company.dto.BookDTO;
import com.company.dto.UserDTO;
import com.company.mapper.BookMapper;
import com.company.mapper.UserMapper;
import com.company.model.Book;
import com.company.model.User;
import com.company.service.UserService;
import com.company.service.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rest/User.svc")
public class UserController {
    /** LOGGER EXAMPLE **/
    private static final Logger LOGGER
            = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final UserMapper userMapper;
    private final BookMapper bookMapper;
    private final UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper, BookMapper bookMapper,
                          UserValidator userValidator) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.bookMapper = bookMapper;
        this.userValidator = userValidator;
    }

    @PostMapping("/user")
    //do validation @Valid
    public UserDTO saveUser(@Valid @RequestBody UserDTO userDTO) {

        /** LOGGER EXAMPLE **/
        LOGGER.debug("DEBUG");
        LOGGER.info("INFO");
        LOGGER.warn("WARN");
        LOGGER.error("ERROR");

        userValidator.checkUserEmailDoesNotExists(userDTO.getEmail());
        return userMapper.toDTO(userService
                .saveUser(userMapper.fromDTO(userDTO)));
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.findAllUsers();
        //EXAMPLE add referenced ENTITY
        return users.stream()
                .map(user -> {
                    Set<Book> userBooks = user.getBooks();
                    UserDTO userDTO = userMapper.toDTO(user);
                    Set<BookDTO> bookDTOS = userBooks.stream()
                            .map(bookMapper::toDTO)
                            .collect(Collectors.toSet());
                    userDTO.setBookDTOSet(bookDTOS);
                    return userDTO;
                })
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

    @GetMapping("/user/book({bookName})")
    public List<UserDTO> getByBookName(@PathVariable("bookName")
                                               String bookName) {
        List<User> users = userService.getUsersByBookName(bookName);
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

}
