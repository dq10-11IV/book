package com.turtledove.bookdrift.infrastruct.dao.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.common.AbstractClass.AbstractTestCase;
import com.turtledove.bookdrift.domain.entity.DomainObjectBuilder;
import com.turtledove.bookdrift.domain.entity.UserBookAss;
import com.turtledove.bookdrift.infrastruct.dao.UserBookAssDao;

public class UserBookAssDaoTest extends AbstractTestCase<UserBookAss>{

	@Autowired
	UserBookAssDao userBookDao;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_findById_and_insert() {
		UserBookAss expectedEntity,actualEntity = create();
		userBookDao.insert(actualEntity);
		expectedEntity = userBookDao.findById(actualEntity.getId().intValue());
		Assert.assertNotNull(expectedEntity);
		Assert.assertEquals(actualEntity.getBookId(), expectedEntity.getBookId());
	}
	@Override
	protected UserBookAss create() {
		return DomainObjectBuilder.newInstance().withField("userId", new Integer(1)).withField("bookId", new Integer(1)).build(UserBookAss.class);
	}

}
