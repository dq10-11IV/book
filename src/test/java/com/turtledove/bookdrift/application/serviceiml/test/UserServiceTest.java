package com.turtledove.bookdrift.application.serviceiml.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.common.AbstractClass.AbstractTestCase;
import com.turtledove.bookdrift.domain.entity.DomainObjectBuilder;
import com.turtledove.bookdrift.domain.entity.Label;
import com.turtledove.bookdrift.domain.entity.User;

public class UserServiceTest extends AbstractTestCase<User>{

	private static final String INSERT_TEST_EMAIL = "insert@test.com";
	private static final String USER_EMAIL = "liubshwzc@gmail.com";
	@Autowired
	private UserService userService;
	
	@Test
	public void test_get_user_by_email() {
		userService.insert(create());
		Assert.assertEquals(userService.getUserByEmail(INSERT_TEST_EMAIL).getUserEmail(), INSERT_TEST_EMAIL);
	}
	
	@Test
	public void test_getTags(){
		List<Label> tags = userService.getTags(USER_EMAIL);
		Assert.assertNotNull(tags);
	}
	
	@Override
	protected User create() {
		return DomainObjectBuilder.newInstance().withField("userEmail", INSERT_TEST_EMAIL)
				.withField("userLevel", 10).withField("userName", "insert").withField("userPwd", "123456")
				.build(User.class);
	}
}