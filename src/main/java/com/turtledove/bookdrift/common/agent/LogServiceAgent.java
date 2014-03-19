package com.turtledove.bookdrift.common.agent;


import org.apache.log4j.Logger;

import com.turtledove.bookdrift.web.AdminLogin;

public class LogServiceAgent {

	private static Logger logger = Logger.getRootLogger();
	
	public static void info(String msg){
		logger.info(msg);
	}
	
	public static void error(String msg){
		logger.error(msg);
	}
	
	public static void error(String msg,Throwable e){
		logger.error(msg, e);
	}
	public static void info(String key,String msg){
		logger.info(key +":"+msg);
	}
}
