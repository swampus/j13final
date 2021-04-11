package com.company;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWourldController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}