package org.example.crudapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/")
    public String welcome() {
        return "CRUD API using Spring Boot, Hibernate, JPA, and MySQL";
    }
    @GetMapping("/secured")
    public String secured() {
        return "Secured endpoint using OAuth2";
    }
}
