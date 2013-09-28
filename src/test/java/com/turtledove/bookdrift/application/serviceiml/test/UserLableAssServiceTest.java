package com.turtledove.bookdrift.application.serviceiml.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserLabelAssService;
import com.turtledove.bookdrift.common.AbstractClass.AbstractTestCase;
import com.turtledove.bookdrift.domain.entity.DomainObjectBuilder;
import com.turtledove.bookdrift.domain.entity.UserLabelAss;

public class UserLableAssServiceTest  extends AbstractTestCase<UserLabelAss>{

	@Autowired
	UserLabelAssService userLabelService;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_findById_and_insert() {
		UserLabelAss expectedEntity ,actualEntity = create();
		userLabelService.insert(actualEntity);
		expectedEntity = userLabelService.findById(actualEntity.getId());
		Assert.assertEquals(expectedEntity.getLabelId(), actualEntity.getLabelId());
	}

	@Override
	protected UserLabelAss create() {
		return DomainObjectBuilder.newInstance().
				   withField("userId", new Integer(1)).withField("labelId", new Integer(100)).
				   build(UserLabelAss.class);
	}

}
