package com.turtledove.bookdrift.application.serviceiml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtledove.bookdrift.application.service.BookService;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.domain.entity.BookInfo;
import com.turtledove.bookdrift.infrastruct.dao.BookDao;

@Service
public class BookServiceIml implements BookService {

	@Autowired
	private BookDao bookDao;
	
	public Integer insert(Book book) {
		return bookDao.insert(book);
	}

	public List<Book> findByBookName(String bookName) {
		return bookDao.findBooksByBooKName(bookName);
	}
	public List<Book> query(BookInfo bookInfo) {
		return bookDao.query(bookInfo);
	}

	public Book findByBookNameAndVersion(String bookName, Integer version) {
		return bookDao.findByBookNameAndVerion(bookName, version);
	}

}
