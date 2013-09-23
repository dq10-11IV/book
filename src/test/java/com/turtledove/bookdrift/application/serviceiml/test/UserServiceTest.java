package com.turtledove.bookdrift.application.serviceiml.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.common.AbstractClass.AbstractDomainObject;
import com.turtledove.bookdrift.common.AbstractClass.AbstractTestCase;
import com.turtledove.bookdrift.domain.entity.DomainObjectBuilder;
import com.turtledove.bookdrift.domain.entity.User;

public class UserServiceTest extends AbstractTestCase<User>{

	private static final String USER_EMAIL = "liubshwzc@gmail.com";
	private static final String INSERT_TEST_EMAIL = "insert@test.com";
	@Autowired
	private UserService userService;
	
	@Test
	public void test_get_user_by_email() {
		userService.insert(create());
		Assert.assertEquals(userService.getUserByEmail(INSERT_TEST_EMAIL).getUserEmail(), INSERT_TEST_EMAIL);
	}
	
	@Override
	protected User create() {
		return DomainObjectBuilder.newInstance().withField("userEmail", INSERT_TEST_EMAIL)
				.withField("userLevel", 10).withField("userName", "insert").withField("userPwd", "123456")
				.build(User.class);
	}
}
