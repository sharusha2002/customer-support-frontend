package com.customer.support.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.customer.support.entities.User;
import com.customer.support.services.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/v1")
public class UserController {
    
    @Autowired
    UserService service;

    @GetMapping("/users/all")
    public ResponseEntity<?> getAllUsers() {
        try {
            Iterable<User> users = service.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch users: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/user/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Invalid user data: " + bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        try {
            service.signUp(user);
            return new ResponseEntity<>("User signed up successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to sign up user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
