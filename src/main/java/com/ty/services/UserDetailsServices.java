package com.ty.services;

import com.ty.dao.UserDetailsDao;
import com.ty.dto.UserDetails;

public class UserDetailsServices {

	public UserDetails saveUserDetails(UserDetails details) {
		
		UserDetailsDao dao = new UserDetailsDao();
		return dao.saveUserDetails(details);
	}
}
