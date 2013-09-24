package com.turtledove.bookdrift.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.common.framework.ProjectConstants;
import com.turtledove.bookdrift.common.utils.LoginUtils;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
	@Autowired UserService userService;
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		if(req.getRequestURI()=="hub.jsp"){ // 需要修改
			if(isFirstAccess(req)){
				if(LoginUtils.isAExistUser()){
					req.setAttribute(ProjectConstants.LOGINED_SESSION, req.getParameter(ProjectConstants.LOGIN_USER_EMAIL));
				}
				else { // 账号密码有问题
				}
			}
		}
		
		chain.doFilter(request, response);
	}

	/*
	 * 第一次登陆，没有sesssion 需要提供登陆账号和密码
	 * */
	private boolean isFirstAccess(HttpServletRequest req) {
		if(req.getAttribute(ProjectConstants.LOGINED_SESSION)==null)
		return false;
		return true;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
