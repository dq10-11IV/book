package com.turtledove.bookdrift.common.utils.test;

import junit.framework.Assert;
import net.sf.json.JSONArray;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.turtledove.bookdrift.common.AbstractClass.AbstractTestCase;
import com.turtledove.bookdrift.common.utils.JsonUtils;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.domain.entity.DomainObjectBuilder;

public class JsonUtilsTest extends AbstractTestCase<Book>{

	private static final int VERSION = 2;
	private static final Double PRICE = 39.1;
	private static final String BOOK_PRESS = "人民出版社";
	private static final String AUTHOR_NAME = "roger";
	private static final String BOOK_NAME = "程序员的修炼之道";
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
   @Test
   public void test_Json_to_JavaBean(){
	   Book book = create();
	   String str = new JSONArray().fromObject(book).toString();
	   System.out.println(str);
	   str = str.substring(2, str.length()-2);
	   Book expect = JsonUtils.JsonToJavaBean(str, Book.class);
	   Assert.assertEquals(book.getAuthorName(),expect.getAuthorName());
   }

   @Override
   protected Book create() {
		return DomainObjectBuilder.newInstance().withField("bookName", BOOK_NAME).
		withField("authorName", AUTHOR_NAME).withField("bookPress", BOOK_PRESS).withField("bookPrice", PRICE)
		.withField("bookVersion", VERSION).build(Book.class);
	}
   

}
