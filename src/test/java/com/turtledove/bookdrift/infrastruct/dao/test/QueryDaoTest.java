package com.turtledove.bookdrift.infrastruct.dao.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.BookService;
import com.turtledove.bookdrift.application.service.UserBookAssService;
import com.turtledove.bookdrift.application.service.UserLabelAssService;
import com.turtledove.bookdrift.application.service.UserService;
import com.turtledove.bookdrift.common.AbstractClass.AbstractTestCase;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.domain.entity.DomainObjectBuilder;
import com.turtledove.bookdrift.domain.entity.User;
import com.turtledove.bookdrift.domain.entity.UserBookAss;
import com.turtledove.bookdrift.domain.entity.UserLabelAss;
import com.turtledove.bookdrift.infrastruct.dao.QueryDao;

public class QueryDaoTest extends AbstractTestCase<Book>{

	private static final int VERSION = 3;
	private static final Double PRICE = 39.1;
	private static final String BOOK_PRESS = "人民出版社";
	private static final String AUTHOR_NAME = "roger";
	private static final String BOOK_NAME = "程序员的修炼之道";
	private static final String ISBN = "9887115215536";
	private String SUMMARY = "三天不读书，智商输给猪";
	private static final String INSERT_TEST_EMAIL = "insert@test.com";
	@Autowired
	QueryDao queryDao;
	@Autowired
	BookService bookService;
	@Autowired
	UserBookAssService userBookAssService;
	@Autowired
	UserService userService;
	@Autowired
	UserLabelAssService userLabelAssService;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_query() {
		Book book = create();
		User user = create_User();
		userService.insert(user);
		bookService.insert(book);
		UserBookAss userBookAss = new UserBookAss();
		userBookAss.setBookId(book.getId());
		userBookAss.setUserId(user.getId());
		userBookAssService.insert(userBookAss);
		UserLabelAss userLabelAss = new UserLabelAss();
		userLabelAss.setUserId(user.getId());
		userLabelAss.setLabelId(1000000);
		userLabelAssService.insert(userLabelAss);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", user.getId());
		map.put("bookName",book.getBookName());
		
		List<Book> queryResult = queryDao.query(map);
		
		Assert.assertEquals(INSERT_TEST_EMAIL, queryResult.get(0).getOwner().getUserEmail());
	    Assert.assertTrue(queryResult.size() > 0);
		Assert.assertNotNull(queryResult);
		Assert.assertNotNull(queryDao);
	}

	protected Book create() {
		return DomainObjectBuilder.newInstance().withField("bookName", BOOK_NAME).
				withField("authorName", AUTHOR_NAME).withField("bookPress", BOOK_PRESS).withField("bookPrice", PRICE).withField("isbn", ISBN).withField("summary", SUMMARY)
				.withField("bookVersion", VERSION).withField("publishDate", new Date()).build(Book.class);
	}

	protected User create_User() {
		return DomainObjectBuilder.newInstance().withField("userEmail", INSERT_TEST_EMAIL)
		.withField("userLevel", 10).withField("userName", "insert").withField("userPwd", "123456")
		.build(User.class);
	}

}
