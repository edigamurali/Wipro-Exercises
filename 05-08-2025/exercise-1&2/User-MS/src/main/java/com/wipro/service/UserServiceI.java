package com.wipro.service;

import java.util.List;

import com.wipro.entity.User;

public interface UserServiceI {

	public String saveUserInfo(User user);
	public String updateUserInfo(User user);
	public List<User> getUserInfo();
	public String delete(User user);
	
}
