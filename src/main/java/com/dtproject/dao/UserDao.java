package com.dtproject.dao;

import com.dtproject.model.User;

public interface UserDao {

	void saveUser(User user);

	User findUserByName(String username);

	User findUserById(int userId);

}
