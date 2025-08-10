package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.dto.UserDto;
import com.wipro.entity.User;
import com.wipro.repo.UserRepo;

@Service
public class UserService implements UserServiceI {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    private static final String url = "http://Notification-MS/notification";

    @Override
    public String saveUserInfo(User user) {
        userRepo.save(user);

        UserDto dto = new UserDto();
        dto.setUserName(user.getUserName());
        dto.setAction("CREATED");

        restTemplate.postForEntity(url, dto, String.class);
        return user.getId()+" id is saved";
    }

    @Override
    public String updateUserInfo(User user) {
        userRepo.save(user);

        UserDto dto = new UserDto();
        dto.setUserName(user.getUserName());
        dto.setAction("UPDATED");

         restTemplate.postForEntity(url, dto, String.class);
        return user.getId()+" id is updated";
    }

    @Override
    public String delete(User user) {
        userRepo.delete(user);

        UserDto dto = new UserDto();
        dto.setUserName(user.getUserName());
        dto.setAction("DELETED");
        restTemplate.postForEntity(url, dto, String.class);
        return user.getId()+" id is deleted";
    }

    @Override
    public List<User> getUserInfo() {
        return userRepo.findAll();
    }
}
