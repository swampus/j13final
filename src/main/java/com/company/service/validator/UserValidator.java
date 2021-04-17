package com.company.service.validator;

import com.company.exception.EmailAlreadyExistsException;
import com.company.model.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

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
}
