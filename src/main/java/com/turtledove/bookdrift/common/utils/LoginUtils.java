package com.turtledove.bookdrift.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.common.framework.ProjectConstants;
import com.turtledove.bookdrift.domain.entity.User;

public class LoginUtils {

	private static UserService userService = Springs.getBean(UserService.class);
	private static String loginEmail;
	private static String  loginPwd ;
	public static boolean isAExistUser(){
		 HttpServletRequest request = getHttpRequest();
		 HttpSession httpSession =getHttpSession();
		 loginEmail = request.getParameter(ProjectConstants.LOGIN_USER_EMAIL);
		 loginPwd = request.getParameter(ProjectConstants.LOGIN_USER_PWD);
		 User user = userService.getUserByEmail(loginEmail);
		if(validateUser(user)){
			httpSession.setAttribute(ProjectConstants.LOGINED_EMAIL_SESSION, loginEmail);
			httpSession.setAttribute(ProjectConstants.LOGIN_ID_SESSION, user.getId());
			return true;
		}
		return false;
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
	private static boolean validateUser(User user){
		if(user!=null && user.getUserEmail().equals(loginEmail) && user.getUserPwd().equals(loginPwd))
			return true;
		return false;
	}
	public static String getCurrentLoginUserEmail(){
		return (String) getHttpRequest().getSession().getAttribute(ProjectConstants.LOGINED_EMAIL_SESSION);
	}
	public static Integer getCurrentLoginUserId(){
		return  (Integer) getHttpSession().getAttribute(ProjectConstants.LOGIN_ID_SESSION);
	}
	private static HttpSession getHttpSession() {
        HttpServletRequest request = getHttpRequest();
        return request.getSession();
    }
    private static HttpServletRequest getHttpRequest(){
    	return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

}
