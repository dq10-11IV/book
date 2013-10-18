package com.turtledove.bookdrift.common.AbstractClass;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml"}) 
@Transactional
public abstract class AbstractTestCase<T extends AbstractDomainObject> {

	protected abstract T create();
}
