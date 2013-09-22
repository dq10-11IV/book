package com.turtledove.bookdrift.application.service;

import java.util.List;

import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.domain.entity.BookInfo;

public interface BookService {
	public Integer insert(Book book);
	public List<Book> findByBookName(String bookName);
	public List<Book> query(BookInfo bookInfo);
}
