package com.turtledove.bookdrift.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.common.framework.ProjectConstants;

public class LoginUtils {

	@Autowired
	private static UserService userService;
	
	public static boolean isAExistUser(){
		HttpServletRequest request = getHttpRequest();
		String loginEmail = request.getParameter(ProjectConstants.LOGIN_USER_EMAIL);
		String loginPwd = request.getParameter(ProjectConstants.LOGIN_USER_PWD);
		return userService.validataUser(loginEmail, loginPwd);
	}
	public static boolean isSessionLogin(){
		HttpSession httpsession = getHttpSession();
		if(httpsession.getAttribute(ProjectConstants.LOGINED_EMAIL_SESSION) != null)
			return true;
		return false;
	}
	public static boolean isFromWelcomePage(){
		HttpServletRequest request = getHttpRequest();
		if(request.getParameter(ProjectConstants.LOGIN_USER_EMAIL)!=null)
			return false;
		return true;
		
	}
	private static HttpSession getHttpSession() {
        HttpServletRequest request = getHttpRequest();
        return request.getSession();
    }
    private static HttpServletRequest getHttpRequest(){
    	
    	return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}
