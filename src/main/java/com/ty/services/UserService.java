package com.ty.services;

import java.util.List;

import com.ty.dao.UserDao;
import com.ty.dto.User;

public class UserService {
	
	UserDao dao = new UserDao();
	public User saveUser(User user) {
		
		return dao.saveUser(user);
	}
	
	public User validateUser(String email, String password){
		
		return dao.validateUser(email, password);
	}
}
