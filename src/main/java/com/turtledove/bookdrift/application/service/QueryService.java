package com.turtledove.bookdrift.application.service;

import java.util.List;
import java.util.Map;

import com.turtledove.bookdrift.domain.entity.Book;

public interface QueryService {

	public List<Book>getBookUnderSpecialTag(String tags);
	public List<Book> getBookUnderUser(Integer Id);
	public List<Book> query(Map<String,Object> para);
	public List<Book> getBooksUnderLableExceptCurrentUser(Map<String,Object> para);
}
