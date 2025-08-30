package com.wipro.user.controller;

import com.wipro.user.dto.Token;
import com.wipro.user.entity.User;
import com.wipro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody User user) {
        return ResponseEntity.ok(userService.login(user));
    }

    // Admin-only
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        userService.deleteById(id);
        return ResponseEntity.ok("Deleted user with id: " + id);
    }

    // Authenticated user (profile)
    @PutMapping("/profile/me")
    public ResponseEntity<User> updateMyProfile(Authentication authentication, @RequestBody User payload) {
        // authentication.getName() returns subject from JWT (we used email)
        String email = authentication.getName();
        User updated = userService.updateProfileByEmail(email, payload);
        return ResponseEntity.ok(updated);
    }
}
