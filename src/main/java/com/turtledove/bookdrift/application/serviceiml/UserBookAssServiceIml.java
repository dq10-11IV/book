package com.turtledove.bookdrift.application.serviceiml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtledove.bookdrift.application.service.BookService;
import com.turtledove.bookdrift.application.service.UserBookAssService;
import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.domain.entity.UserBookAss;
import com.turtledove.bookdrift.infrastruct.dao.UserBookAssDao;

@Service
public class UserBookAssServiceIml implements UserBookAssService {

	@Autowired
	UserBookAssDao userBookAssDao;
	@Autowired
	BookService bookService;
	
	public int insert(UserBookAss userBookAss) {
		return userBookAssDao.insert(userBookAss);
	}
	public UserBookAss findById(Integer Id) {
		return userBookAssDao.findById(Id);
	}
	public void save(Book book,UserBookAss userBookAss){
		if(bookService.findByBookNameAndVersion(book.getBookName(), book.getBookVersion())==null)
			bookService.insert(book);
		insert(userBookAss);
	}
}
