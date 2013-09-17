package com.turtledove.bookdrift.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.domain.entity.User;

public class AdminLogin {

	private static final String USER_EMAIL = "liubshwzc@gmail.com";
	@Autowired
	UserService userService;
	private Map<String, Object> result = new HashMap<String, Object>();

	public String login() {
		  User user = new User(); user.setUserEmail(USER_EMAIL);
		  user.setUserLevel(1); user.setUserName("liubsh");
		  user.setUserPwd("123456");
		result.put("code", 200);
		result.put("success", userService.getUserByEmail(USER_EMAIL));
		return "success";
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
}
