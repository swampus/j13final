package com.company.service.validator;

import com.company.exception.*;
import com.company.model.Book;
import com.company.model.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserValidator {

    private final static int MAX_BOOKS_PER_USER = 5;

    private final UserRepository userRepository;

    @Autowired
    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void checkUserEmailDoesNotExists(String email) {
        User user = new User();
        user.setEmail(email);
        Example<User> userExample = Example.of(user);
        userRepository.findOne(userExample)
                .ifPresent(t -> {
                    throw new EmailAlreadyExistsException(
                            "Email AlreadyExists!: " + t.getEmail());
                });
    }

    public User checkUserExists(Long userId) {
        Optional<User> userFromDBOpt = userRepository.findById(userId);
        return userFromDBOpt.orElseThrow(() ->
                new EntityDoesNotExistsException("User: (" + userId + ") not exists!"));
    }

    public void checkUserHaveBook(User user, Long bookId) {
        if (!user.getBooks().stream().map(Book::getId)
                .collect(Collectors.toSet()).contains(bookId)) {
            throw new UserDoesNotHaveThatBookException("user("
                    + user.getId() + ") does not have book (" + bookId + ")");
        }
    }

    public void checkUserHaveLoyaltyCard(User user, Long loyaltyCardId) {
        if (!user.getBooks().stream().map(Book::getId)
                .collect(Collectors.toSet()).contains(loyaltyCardId)) {
            throw new UserDoesNotHaveThatLoyaltyCardException("user("
                    + user.getId() + ") does not have loyaltyCardId (" + loyaltyCardId + ")");
        }
    }

    public void checkUserDoesNotHaveMoreThenFiveBook(User user) {
        if (user.getBooks().size() >= MAX_BOOKS_PER_USER) {
            throw new UserHaveToManyBooksException("User ("
                    + user.getId() + ") have to many books!");
        }
    }


}
