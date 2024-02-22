package com.customer.support;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.customer.support.entities.User;
import com.customer.support.repositories.UserRepository;
import com.customer.support.services.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testSignUp_UserAlreadyExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUserMail("existing@example.com");
        when(userRepository.findByUserMail("existing@example.com")).thenReturn(Optional.of(existingUser));

        User newUser = new User();
        newUser.setUserMail("existing@example.com");

        // Act
        String result = userService.signUp(newUser);

        // Assert
        assertEquals("user mail already registered", result);
    }

    @Test
    public void testSignUp_SuccessfulRegistration() {
        // Arrange
        when(userRepository.findByUserMail(any())).thenReturn(Optional.empty());

        User newUser = new User();
        newUser.setUserMail("new@example.com");

        // Act
        String result = userService.signUp(newUser);

        // Assert
        assertEquals("user registration successful", result);
    }

    @Test
    public void testSignIn_UserDoesNotExist() {
        // Arrange
        when(userRepository.findByUserMail(any())).thenReturn(Optional.empty());

        // Act
        String result = userService.signIn("nonexistent@example.com", "password");

        // Assert
        assertEquals("user does not exist", result);
    }

    @Test
    public void testSignIn_IncorrectPassword() {
        // Arrange
        User existingUser = new User();
        existingUser.setUserMail("existing@example.com");
        existingUser.setPassword("password");
        when(userRepository.findByUserMail("existing@example.com")).thenReturn(Optional.of(existingUser));

        // Act
        String result = userService.signIn("existing@example.com", "incorrect");

        // Assert
        assertEquals("enter valid password", result);
    }

    @Test
    public void testSignIn_SuccessfulSignIn() {
        // Arrange
        User existingUser = new User();
        existingUser.setUserMail("existing@example.com");
        existingUser.setPassword("password");
        when(userRepository.findByUserMail("existing@example.com")).thenReturn(Optional.of(existingUser));

        // Act
        String result = userService.signIn("existing@example.com", "password");

        // Assert
        assertEquals("signin successful", result);
    }
}