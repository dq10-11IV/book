package com.turtledove.bookdrift.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.BookService;
import com.turtledove.bookdrift.common.framework.AjaxBase;
import com.turtledove.bookdrift.domain.entity.Book;

public class BookAction extends AjaxBase{

	@Autowired
	BookService bookService;
	public  String bookName;
	public String query(){
		List<Book> bookList = bookService.findByBookName(bookName);
		setSuccessfulResult(bookList);
		return SUCCESS;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	
}
