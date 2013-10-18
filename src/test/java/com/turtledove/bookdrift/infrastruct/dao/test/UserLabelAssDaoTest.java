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

	private static final int NEW_LABEL_ID = -999;
	private static final int LABEL_ID = -1000;
	private static final int USER_ID = 1;
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
	@Test
	public void test_update_userLabelAss(){
		UserLabelAss expectedEntity ,actualEntity = create();
		userLabelDao.insert(actualEntity);
		userLabelDao.update(1, LABEL_ID, NEW_LABEL_ID);
	    expectedEntity = userLabelDao.findById(actualEntity.getId());
	    Assert.assertEquals(expectedEntity.getLabelId().intValue(), NEW_LABEL_ID);
	}
	@Test
	public void test_findByuserIdAndLabelId(){
		UserLabelAss expectedEntity ,actualEntity = create();
		userLabelDao.insert(actualEntity);
		expectedEntity = userLabelDao.findByUserIdAndLabelId(new Integer(USER_ID), new Integer(LABEL_ID));
		Assert.assertEquals(expectedEntity.getId(), actualEntity.getId());
		  
	}
	@Override
	protected UserLabelAss create() {
		return DomainObjectBuilder.newInstance().
			   withField("userId", new Integer(1)).withField("labelId", new Integer(LABEL_ID)).
			   build(UserLabelAss.class);
	}
   
}
