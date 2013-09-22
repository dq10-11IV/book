package com.turtledove.bookdrift.web;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.common.framework.ActionMessage;
import com.turtledove.bookdrift.common.framework.AjaxBase;
import com.turtledove.bookdrift.common.utils.JsonUtils;
import com.turtledove.bookdrift.domain.entity.User;

public class AdminLogin extends AjaxBase{

	public String data;
	@Autowired
	UserService userService;
	/*
	 * 用户注册时的action
	 * */
	public String register(){
        User user;
		try {
			user = JsonUtils.JsonToJavaBean(enCoding(data), User.class);
			user.setCreateDate(new Date());
			user.setLastUpdateDate(new Date());
			userService.insert(user);
		    setSuccessResult(user);
		} catch (Exception e) {
			setFailureResult(ActionMessage.FINAL_EXCEPTION_MESSAGE);
		}
		return SUCCESS;
	}
	public String login() {
		return "success";
	}
}
