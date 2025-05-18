package com.ladalee.ladalee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladalee.ladalee.model.User;

@RestController
@RequestMapping("/api")
public class TestController {

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.ok("Created user: " + user.getName());
    }
      @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleJsonParseError(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body("Invalid JSON input: " + ex.getMostSpecificCause().getMessage());
    }
}
