package com.turtledove.bookdrift.application.serviceiml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Book book,UserBookAss userBookAss){
		Book findBook =bookService.findByISBN(book.getIsbn());
		Integer bookId = null;
		if(findBook==null){
			bookService.insert(book);
			findBook = book;
		}
		bookId = findBook.getId();
		userBookAss.setBookId(bookId);
		if(findByUserIdAndBookId(userBookAss.getUserId(), userBookAss.getBookId())==null)
		insert(userBookAss);
	}
	public UserBookAss findByUserIdAndBookId(Integer userId, Integer bookId) {
		return userBookAssDao.findByUserIdAndBookId(userId,bookId);
	}
}
