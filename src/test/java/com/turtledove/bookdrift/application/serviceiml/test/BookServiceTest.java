package com.turtledove.bookdrift.application.serviceiml.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.BookService;
import com.turtledove.bookdrift.common.AbstractClass.AbstractTestCase;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.domain.entity.DomainObjectBuilder;
import com.turtledove.bookdrift.infrastruct.dao.BookDao;

public class BookServiceTest extends AbstractTestCase<Book>{

	private static final int VERSION = 3;
	private static final Double PRICE = 39.1;
	private static final String BOOK_PRESS = "人民出版社";
	private static final String AUTHOR_NAME = "roger";
	private static final String BOOK_NAME = "程序员的修炼之道";
	private static final String ISBN = "9887115215536";
	private String SUMMARY = "三天不读书，智商输给猪";
	@Autowired
	BookDao bookDao;
	@Autowired 
	BookService bookService;
	@Before
	public void setUp() throws Exception {
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_insert_and_findById(){
		Book actualEntity = create(),expectedEntity;
		bookService.insert(actualEntity);
		expectedEntity = bookDao.findById(actualEntity.getId());
		Assert.assertNotNull(expectedEntity);
		Assert.assertEquals(expectedEntity.getAuthorName(), actualEntity.getAuthorName());
		Assert.assertEquals(expectedEntity.getSummary(), actualEntity.getSummary());
	}
	@Test
	public void test_find_books_by_bookName() {
		Book book = create();
		bookDao.insert(book);
		List<Book> bookList = new ArrayList<Book>();
		bookList = bookService.findByBookName(book.getBookName());
		Assert.assertNotNull(bookList);
	}
	@Test
	public void test_findbook_by_name_and_verion(){
		Book actualEntity = create(),expectedEntity;
		bookService.insert(actualEntity);
		expectedEntity = bookService.findByBookNameAndVersion(BOOK_NAME, VERSION);
		Assert.assertNotNull(expectedEntity);
		Assert.assertEquals(expectedEntity.getAuthorName(), actualEntity.getAuthorName());
		
	}
	@Test
	public void test_findbook_by_isbn(){
		Book actualEntity = create(),expectedEntity;
		bookService.insert(actualEntity);
		expectedEntity = bookService.findByISBN(actualEntity.getIsbn());
		Assert.assertNotNull(expectedEntity);
		Assert.assertEquals(expectedEntity.getAuthorName(), actualEntity.getAuthorName());
	}
	@Override
	protected Book create() {
		return DomainObjectBuilder.newInstance().withField("bookName", BOOK_NAME).
				withField("authorName", AUTHOR_NAME).withField("bookPress", BOOK_PRESS).withField("bookPrice", PRICE).withField("isbn", ISBN).withField("summary", SUMMARY)
				.withField("bookVersion", VERSION).withField("publishDate", new Date()).build(Book.class);
	}
}
