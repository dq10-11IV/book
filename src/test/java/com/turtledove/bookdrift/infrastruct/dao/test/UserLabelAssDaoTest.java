package com.turtledove.bookdrift.infrastruct.dao.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.common.AbstractClass.AbstractTestCase;
import com.turtledove.bookdrift.domain.entity.DomainObjectBuilder;
import com.turtledove.bookdrift.domain.entity.UserLabelAss;
import com.turtledove.bookdrift.infrastruct.dao.UserLabelAssDao;

public class UserLabelAssDaoTest extends AbstractTestCase<UserLabelAss> {

	@Autowired
	UserLabelAssDao userLabelDao;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_findById_and_insert() {
		UserLabelAss expectedEntity ,actualEntity = create();
		userLabelDao.insert(actualEntity);
		expectedEntity = userLabelDao.findById(actualEntity.getId());
		Assert.assertEquals(expectedEntity.getLabelId(), actualEntity.getLabelId());
	}

	@Test
	public void test_validate_userLabel(){
		UserLabelAss expectedEntity ,actualEntity = create();
		userLabelDao.insert(actualEntity);
		expectedEntity = userLabelDao.ValidateUserLabelAss(actualEntity);
		Assert.assertEquals(expectedEntity.getLabelId(), actualEntity.getLabelId());
	}
	@Override
	protected UserLabelAss create() {
		return DomainObjectBuilder.newInstance().
			   withField("userId", new Integer(1)).withField("labelId", new Integer(100)).
			   build(UserLabelAss.class);
	}

}
