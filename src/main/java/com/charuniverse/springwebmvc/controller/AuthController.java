package com.charuniverse.springwebmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> login(@RequestParam("username") String username,
                                        @RequestParam("password") String password,
                                        HttpServletResponse response) {
        if ("admin".equals(username) && "admin".equals(password)) {
            Cookie cookie = new Cookie("username", username);
            cookie.setPath("/");
            response.addCookie(cookie);

            return ResponseEntity.ok("Login success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    @GetMapping("/auth/user")
    public ResponseEntity<String> getUser(@CookieValue("username") String username) {
        return ResponseEntity.ok("Hello " + username);
    }
}
