package com.turtledove.bookdrift.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.common.framework.ActionMessage;
import com.turtledove.bookdrift.common.framework.AjaxBase;
import com.turtledove.bookdrift.common.utils.JsonUtils;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.User;

public class AdminLogin extends AjaxBase{

	public String data;
	public String fieldName;
	public String fieldValue;
	@Autowired
	UserService userService;
	/*
	 * 用户注册时的actionO
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
		if(LoginUtils.isFromWelcomePage()) 
			return TOLOGINPAGE;
		if(LoginUtils.isAExistUser())
			return TO_HUB_PAGE;
		return SUCCESS;
	}
	public String validation(){
		if(fieldName.equals("userEmail")){
			if(userService.validateEmail(fieldValue))
				setSuccessResult(ActionMessage.EXIST);
			else setFailureResult(ActionMessage.NOT_EXIST);
		}
		return SUCCESS;
	}
}
