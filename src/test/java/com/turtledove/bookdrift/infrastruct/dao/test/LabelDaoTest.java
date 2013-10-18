package com.turtledove.bookdrift.infrastruct.dao.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.common.AbstractClass.AbstractTestCase;
import com.turtledove.bookdrift.domain.entity.DomainObjectBuilder;
import com.turtledove.bookdrift.domain.entity.Label;
import com.turtledove.bookdrift.infrastruct.dao.LabelDao;

public class LabelDaoTest extends AbstractTestCase<Label>{

	@Autowired
	LabelDao labelDao;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_getTags() {
		List<Label> LabelList = labelDao.getTags("liubshwzc@gmail.com");
		System.out.println(LabelList.size());
		Assert.assertNotNull(LabelList);
	}

	@Test
	public void test_findById_and_insert(){
		Label label = create();
		labelDao.insert(label);
		Label find = labelDao.findById(label.getId());
		Assert.assertEquals(label.getLabelName(), find.getLabelName());
	}
	@Test
	public void test_findByByLabelName(){
		Label label = create();
		labelDao.insert(label);
		Label find = labelDao.findByLabelName(label.getLabelName());
		Assert.assertNotNull(find);
		Assert.assertEquals(label.getLabelName(), find.getLabelName());
		
	}
	@Override
	protected Label create() {
		return DomainObjectBuilder.newInstance().withField("labelName", "114").withField("creatorId", new Integer(1)).build(Label.class);
	}

}
