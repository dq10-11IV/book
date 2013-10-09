package com.turtledove.bookdrift.application.service;

import com.turtledove.bookdrift.domain.entity.Book;
import com.turtledove.bookdrift.domain.entity.UserBookAss;

public interface UserBookAssService {

	public int insert(UserBookAss userBook);
	public UserBookAss findById(Integer Id);
	public void save(Book book,UserBookAss userBookAss);
	public UserBookAss findByUserIdAndBookId(Integer userId, Integer bookId);
}
