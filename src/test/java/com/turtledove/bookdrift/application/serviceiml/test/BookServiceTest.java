package com.turtledove.bookdrift.application.serviceiml.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.common.AbstractClass.AbstractTestCase;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.infrastruct.dao.BookDao;

public class BookServiceTest extends AbstractTestCase<Book>{

	@Autowired
	BookDao bookDao;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_find_books_by_bookName() {
		List<Book> bookList = new ArrayList<Book>();
		bookList = bookDao.findBooksByBooKName(null);
		System.out.println(bookList.size());
		Assert.assertNotNull(bookList);
	}

	@Override
	protected Book create() {
		// TODO Auto-generated method stub
		return null;
	}

}
