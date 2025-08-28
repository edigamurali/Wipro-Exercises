package com.wipro.usermgmtv2.controller;

import com.wipro.usermgmtv2.entity.User;
import com.wipro.usermgmtv2.model.Token;
import com.wipro.usermgmtv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteById(id);
    }

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        userService.save(user);
    }

    @PostMapping("/login")
    public Token login(@RequestBody User user) {
        return userService.login(user);
    }
}
