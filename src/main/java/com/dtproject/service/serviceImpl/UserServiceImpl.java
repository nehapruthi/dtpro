package com.dtproject.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtproject.dao.UserDao;
import com.dtproject.model.User;
import com.dtproject.service.UserService;
@Service
public class UserServiceImpl implements UserService
{
	 @Autowired
	 UserDao userDao;
	 
    @Override
	public void saveUser(User user) 
    {
		userDao.saveUser(user);	
	}

	@Override
	public User findUserByName(String username) {
		User user=userDao.findUserByName(username);
		return user;
		
	}

	@Override
	public User findUserById(int userId) {
		User user=userDao.findUserById(userId);
		return user;
	}

}
