package com.turtledove.bookdrift.application.service;

import java.util.List;

import com.turtledove.bookdrift.domain.entity.Book;

public interface QueryService {

	public List<Book>getBookUnderUserAndSpecailTag(String email,String tags);
	public List<Book>getBookUnderSpecialTag(String tags);
	public List<Book> getBookUnderUser(Integer Id);
}
