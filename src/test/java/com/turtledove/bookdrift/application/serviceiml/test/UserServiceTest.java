package com.turtledove.bookdrift.application.serviceiml.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.common.AbstractClass.AbstractDomainObject;
import com.turtledove.bookdrift.common.AbstractClass.AbstractTestCase;
import com.turtledove.bookdrift.domain.entity.User;

public class UserServiceTest extends AbstractTestCase<User>{

	private static final String USER_EMAIL = "liubshwzc@gmail.com";
	@Autowired
	private UserService userService;
	
	@Test
	public void test_get_user_by_email() {
		Assert.assertEquals(userService.getUserByEmail(USER_EMAIL).getUserEmail(), USER_EMAIL);
	}
	
	@Test
	public void test_insert_and_update_Primary(){
	  
	}
	@Override
	protected User create() {
		
		return null;
	}
}
