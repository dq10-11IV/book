package com.turtledove.bookdrift.application.serviceiml.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserBookAssService;
import com.turtledove.bookdrift.common.AbstractClass.AbstractTestCase;
import com.turtledove.bookdrift.domain.entity.DomainObjectBuilder;
import com.turtledove.bookdrift.domain.entity.UserBookAss;

public class UserBookAssServiceTest  extends AbstractTestCase<UserBookAss>{

	@Autowired
	UserBookAssService userBookAssService;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_findById_and_insert() {
		UserBookAss  expectedEnity, actualEntity = create();
		userBookAssService.insert(actualEntity);
		expectedEnity = userBookAssService.findById(actualEntity.getId());
		Assert.assertNotNull(expectedEnity);
		Assert.assertEquals(expectedEnity.getBookId(),actualEntity.getBookId());
		
	}
	@Override
	protected UserBookAss create() {
		return DomainObjectBuilder.newInstance().withField("userId", new Integer(1)).withField("bookId", new Integer(1)).build(UserBookAss.class);
	}

}
