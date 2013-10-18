package com.turtledove.bookdrift.common.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	@Autowired
	UserService userService;
	Pattern notNeedFilterURLPattern;

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
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse  = (HttpServletResponse) response;
		Matcher matcher = notNeedFilterURLPattern.matcher(httpRequest.getRequestURI());
		if (matcher.matches()) { //不需要过滤的uri
			chain.doFilter(request, response);
			return;
		}
		if(LoginUtils.isSessionLogin())
			chain.doFilter(request, response);
		else httpResponse.sendRedirect("/login");

	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		notNeedFilterURLPattern = Pattern.compile(fConfig.getInitParameter(ProjectConstants.NOT_NEED_LOGIN_FILTER_URL));
	}

}
