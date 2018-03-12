package com.dtproject.service;

import com.dtproject.model.User;

public interface UserService {

	void saveUser(User user);

	User findUserByName(String username);

	User findUserById(int userId);

	

}
