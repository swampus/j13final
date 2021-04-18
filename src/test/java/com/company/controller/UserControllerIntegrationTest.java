package com.company.controller;

import com.company.dto.ErrorDTO;
import com.company.dto.UserDTO;
import com.company.model.User;
import com.company.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class UserControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getUserById() {
        UserDTO userDTO = this.restTemplate.getForObject("http://localhost:"
                        + port + "/api/rest/User.svc/user(2)",
                UserDTO.class);
        assertEquals("john444", userDTO.getUsername());
        assertEquals("jouhn@noemail.com", userDTO.getEmail());
    }

    @Test
    public void saveUser() throws JsonProcessingException {
        UserDTO userDTOtoInsert = new UserDTO();
        userDTOtoInsert.setEmail("test@test.com");
        userDTOtoInsert.setAddress("AADDRR");
        userDTOtoInsert.setPersonalCode("123456789");
        userDTOtoInsert.setUsername("newUserNa");

        HttpEntity<UserDTO> request =
                new HttpEntity<>(userDTOtoInsert);
        UserDTO user = this.restTemplate.postForObject("http://localhost:"
                        + port + "/api/rest/User.svc/user", request,
                UserDTO.class);

        assertNotNull(user);
        Long id = user.getId();
        User userSaved = userRepository.getOne(id);

        assertEquals("newUserNa", userSaved.getUsername());
        assertEquals("123456789", userSaved.getPersonalCode());
        assertEquals("test@test.com", userSaved.getEmail());

        userRepository.delete(userSaved);
    }

    @Test
    public void saveUserWithError() throws JsonProcessingException {
        UserDTO userDTOtoInsert = new UserDTO();
        userDTOtoInsert.setEmail("test@test.com");
        userDTOtoInsert.setAddress("AADDRR");
        userDTOtoInsert.setUsername("newUserNa");

        HttpEntity<UserDTO> request =
                new HttpEntity<>(userDTOtoInsert);
        ErrorDTO userError = this.restTemplate.postForObject("http://localhost:"
                        + port + "/api/rest/User.svc/user", request,
                ErrorDTO.class);

        assertNotNull(userError);

        assertEquals("/api/rest/User.svc/user",
                userError.getPath());
        assertEquals("userDTO personal code can not be null ",
                userError.getMessage());
    }

    @Test
    public void getAllUsers() {
    }

    @Test
    public void getByFavoriteBook() {
    }

    @Test
    public void getByBookName() {
    }
}
