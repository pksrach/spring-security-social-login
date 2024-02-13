package com.oauth.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class WelcomeController {
    @GetMapping
    public Map<String, Object> welcome() {
        return Map.of(
                "message", "Welcome to the OAuth2 Demo!",
                "goto", "http://localhost:8080/secured"
        );
    }

    @GetMapping("/secured")
    public Map<String, Object> secure() {
        return Map.of(
                "message", "You have successfully authenticated with third party!",
                "goto", "http://localhost:8080/user"
        );
    }

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
