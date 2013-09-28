package com.turtledove.bookdrift.application.serviceiml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtledove.bookdrift.application.service.LabelService;
import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.domain.entity.Label;
import com.turtledove.bookdrift.domain.entity.User;
import com.turtledove.bookdrift.infrastruct.dao.UserDao;

@Service
public class UserServiceIml implements UserService {

	@Autowired
	private LabelService labelService;
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
		if(user!=null && user.getUserPwd().equals(pwd))
			return true;
		return false;
	}
	public List<Label> getTags(String email) {
	  return labelService.getLabelsByEmail(email);
	}
}
