package com.turtledove.bookdrift.application.serviceiml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtledove.bookdrift.application.service.QueryService;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.infrastruct.dao.BookDao;

@Service
public class QueryServiceIml implements QueryService {

	@Autowired 
	BookDao bookDao;
	public List<Book> getBookUnderEmailAndSpecailTag(String email, String tag) {
		Map<String,String> paraMap = new HashMap<String, String>();
		paraMap.put("email", email);
		paraMap.put("tag", tag);
		return bookDao.getBooksUnderEmailAndTag(paraMap);
	}
}
