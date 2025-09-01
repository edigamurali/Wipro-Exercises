package com.wipro.user.controller;

import com.wipro.user.dto.Token;
import com.wipro.user.entity.User;
import com.wipro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User Management", description = "APIs for user registration, login, and profile management")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public ResponseEntity<User> register(@RequestBody User user) {
        System.out.println("Registration request received for: " + user.getEmail());
        try {
            User registeredUser = userService.register(user);
            System.out.println("User registered successfully: " + registeredUser.getEmail());
            return ResponseEntity.ok(registeredUser);
        } catch (Exception e) {
            System.out.println("Registration failed: " + e.getMessage());
            throw e;
        }
    }

    @PostMapping("/login")
    @Operation(summary = "User login")
    public ResponseEntity<Token> login(@RequestBody User user) {
        System.out.println("Login request received for: " + user.getEmail());
        try {
            Token token = userService.login(user);
            System.out.println("Login successful for: " + user.getEmail());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
            throw e;
        }
    }

    @PostMapping("/logout")
    @Operation(summary = "User logout")
    public ResponseEntity<String> logout() {
        System.out.println("Logout request received");
        return ResponseEntity.ok("User logged out successfully");
    }

    @GetMapping
    @Operation(summary = "Get all users (Admin only)")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID (Admin only)")
    public ResponseEntity<User> getById(@PathVariable int id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user (Admin only)")
    public ResponseEntity<String> delete(@PathVariable int id) {
        userService.deleteById(id);
        return ResponseEntity.ok("Deleted user with id: " + id);
    }

    @PutMapping("/profile/me")
    @Operation(summary = "Update user profile")
    public ResponseEntity<User> updateMyProfile(Authentication authentication, @RequestBody User payload) {
        String email = authentication.getName();
        User updated = userService.updateProfileByEmail(email, payload);
        return ResponseEntity.ok(updated);
    }
}