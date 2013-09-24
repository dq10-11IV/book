package com.turtledove.bookdrift.application.serviceiml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.domain.entity.User;
import com.turtledove.bookdrift.infrastruct.dao.UserDao;

@Service
public class UserServiceIml implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUserByEmail(String email) {
		return userDao.getUser(email);
	}
    public int insert(User user){
    	return userDao.insert(user);
    }
	public boolean validateEmail(String email) {
		if(getUserByEmail(email)!=null)
			return true;
		return false;
	}
	public boolean validataUser(String email, String pwd) {
		User user = userDao.getUser(email);
		if(user.getUserPwd().equals(pwd))
			return true;
		return false;
	}
}
