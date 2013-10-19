package com.turtledove.bookdrift.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public final class Springs implements ApplicationContextAware ,DisposableBean{

	private static ApplicationContext applicationContext;
	
	public static <T> T getBean(Class<T> clazz){
		return applicationContext.getBean(clazz);
	}
	public void destroy() throws Exception {
		applicationContext = null;
	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.applicationContext = arg0;
	}

	
}
