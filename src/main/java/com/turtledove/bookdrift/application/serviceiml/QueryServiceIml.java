package com.turtledove.bookdrift.application.serviceiml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtledove.bookdrift.application.service.QueryService;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.infrastruct.dao.BookDao;
import com.turtledove.bookdrift.infrastruct.dao.QueryDao;

@Service
public class QueryServiceIml implements QueryService {

	@Autowired 
	BookDao bookDao;
	@Autowired
	QueryDao queryDao;
	public List<Book> getBookUnderUser(Integer Id) {
		return bookDao.getBookUnderUser(Id);
	}
	public List<Book> getBookUnderSpecialTag(String tags) {
		return  bookDao.getBookUnderSpecialTag(tags);
	}
	public List<Book> query(Map<String, Object> para) {
		return queryDao.query(para);
	}
	public List<Book> getBooksUnderLableExceptCurrentUser(Map<String, Object> para) {
		return queryDao.getBooksUnderLableExceptCurrentUser(para);
	}
	
}
