package com.turtledove.bookdrift.application.serviceiml.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.common.AbstractClass.AbstractTestCase;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.domain.entity.BookInfo;
import com.turtledove.bookdrift.domain.entity.DomainObjectBuilder;
import com.turtledove.bookdrift.infrastruct.dao.BookDao;

public class BookServiceTest extends AbstractTestCase<Book>{

	private static final int VERSION = 2;
	private static final int PRICE = 39;
	private static final String BOOK_PRESS = "人民出版社";
	private static final String AUTHOR_NAME = "roger";
	private static final String BOOK_NAME = "程序员的修炼之道";
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
		Book book = create();
		bookDao.insert(book);
		List<Book> bookList = new ArrayList<Book>();
		bookList = bookDao.findBooksByBooKName(book.getBookName());
		Assert.assertNotNull(bookList);
	}
	@Test
	public void test_query(){
		bookDao.insert(create());
		BookInfo bookInfo = create_BookInfo();
		List<Book> booklist = new ArrayList<Book>();
		booklist =bookDao.query(bookInfo);
		Assert.assertTrue(booklist.size() > 0);
		Assert.assertEquals(bookInfo.getBookName(), booklist.get(0).getBookName());
	}
	@Override
	protected Book create() {
		return DomainObjectBuilder.newInstance().withField("bookName", BOOK_NAME).
				withField("authorName", AUTHOR_NAME).withField("bookPress", BOOK_PRESS).withField("bookPrice", PRICE)
				.withField("bookVersion", VERSION).withField("publishDate", new Date()).build(Book.class);
	}
	private BookInfo create_BookInfo(){
		return DomainObjectBuilder.newInstance().withField("bookName", BOOK_NAME).withField("authorName", AUTHOR_NAME)
				.withField("version", VERSION).withField("press", BOOK_PRESS).build(BookInfo.class);
	}

}
