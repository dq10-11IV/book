package com.turtledove.bookdrift.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.BookService;
import com.turtledove.bookdrift.common.framework.AjaxBase;
import com.turtledove.bookdrift.domain.entity.Book;
public class BookAction extends AjaxBase {

	@Autowired
	BookService bookService;
	public String bookName;
	public String book;

	public String query() throws UnsupportedEncodingException {
		List<Book> bookList = bookService.findByBookName(enCoding(bookName));
		setSuccessResultWithList(bookList);
		System.out.println(enCoding(bookName));
		return SUCCESS;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	private String enCoding(String key) throws UnsupportedEncodingException{
		String key_copy = new String(key.getBytes("ISO-8859-1"), "UTF-8");
		key = key_copy;
		return key;
	}
}
