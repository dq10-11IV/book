package com.turtledove.bookdrift.application.service;

import java.util.List;

import com.turtledove.bookdrift.domain.entity.Label;
import com.turtledove.bookdrift.domain.entity.User;

public interface UserService {

	public User getUserByEmail(String email);
	public int  insert(User user);
	public boolean validateEmail(String email);
	public boolean validataUser(String email,String pwd);
	public List<Label> getTags(String email);
}
