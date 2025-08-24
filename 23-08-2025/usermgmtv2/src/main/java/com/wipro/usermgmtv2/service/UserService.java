package com.wipro.usermgmtv2.service;

import com.wipro.usermgmtv2.entity.User;
import com.wipro.usermgmtv2.model.Token;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    void save(User user);
    void deleteById(int id);
    Token login(User user);
}
