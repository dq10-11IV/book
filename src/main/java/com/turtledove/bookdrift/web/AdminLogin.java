package com.turtledove.bookdrift.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.common.framework.ActionMessage;
import com.turtledove.bookdrift.common.framework.AjaxBase;
import com.turtledove.bookdrift.common.utils.JsonUtils;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.User;

public class AdminLogin extends AjaxBase{

	public String data;
	public String email;

	public String passwd;
	public String username;
	public String fieldName;
	public String fieldValue;
	@Autowired
	UserService userService;
	/*
	 * 用户注册时的actionO
	 * */
	public String register(){
		if(username == null && email==null)
			return TO_REGISTER_PAGE;
        User user = new User();
		try {
			//user = JsonUtils.JsonToJavaBean(enCoding(data), User.class);
			user.setUserEmail(email);
			user.setUserName(username);
			user.setUserPwd(passwd);
			user.setCreateDate(new Date());
			user.setLastUpdateDate(new Date());
			userService.insert(user);
		    setSuccessResult(user);
		} catch (Exception e) {
			setFailureResult(ActionMessage.FINAL_EXCEPTION_MESSAGE);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String login() {
		if(LoginUtils.isFromWelcomePage()){
			getRequest().put("jsonResult", setJsonResult());
			return TOLOGINPAGE;
		}
		if(LoginUtils.isAExistUser())
			return TO_HUB_PAGE;
		
		setElementInDate("email", email);
		if(userService.getUserByEmail(email)==null)
		setDateWithErrorMsg(ActionMessage.EMIAL_ERROE);
		else setDateWithErrorMsg(ActionMessage.PASS_WORD_ERROR);
		getRequest().put("jsonResult", setJsonResult());
		return TOLOGINPAGE;
	}
	public String validation(){
		if(fieldName.equals("email")){
			if(userService.validateEmail(fieldValue))
				setDateWithErrorMsg("");
			else setDateWithErrorMsg(ActionMessage.USER_EXIST);
		}
		getRequest().put("jsonResult", setJsonResult());
		return SUCCESS;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
