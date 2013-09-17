package com.turtledove.bookdrift.application.serviceiml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtledove.bookdrift.application.service.BookService;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.infrastruct.dao.BookDao;

@Service
public class BookServiceIml implements BookService {

	@Autowired
	private BookDao bookDao;
	
	public Integer insert(Book book) {
		return bookDao.insert(book);
	}

}
