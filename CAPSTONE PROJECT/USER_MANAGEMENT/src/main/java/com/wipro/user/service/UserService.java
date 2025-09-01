package com.wipro.user.service;

import com.wipro.user.dto.Token;
import com.wipro.user.entity.User;
import java.util.List;

public interface UserService {
    User register(User user);
    Token login(User user);
    List<User> findAll();
    User findById(int id);
    void save(User user);
    void deleteById(int id);

   
    User updateProfileByEmail(String email, User payload);
}
