package com.turtledove.bookdrift.application.service;

import java.util.List;

import com.turtledove.bookdrift.domain.entity.Book;

public interface QueryService {

	public List<Book>getBookUnderEmailAndSpecailTag(String email,String tags);
}
