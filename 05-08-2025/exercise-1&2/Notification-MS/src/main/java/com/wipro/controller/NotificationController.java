package com.wipro.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.UserDto;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @PostMapping
    public void notify(@RequestBody UserDto userDto) {
        String msg = "User " + userDto.getUserName() + " information is " + userDto.getAction();
        System.out.println(msg);
    }
}
